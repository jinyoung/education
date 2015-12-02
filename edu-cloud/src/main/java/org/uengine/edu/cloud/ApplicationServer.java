package org.uengine.edu.cloud;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.util.Hashtable;


public class ApplicationServer extends AbstractServer implements InvocationHandler{
	

//------------------ For Server ----------------------//

	Hashtable serviceRepository = new Hashtable();
	
	public ApplicationServer(){
		this(null, null);
	}
	
	public void handleSession(InputStream in, OutputStream out) {
		
		final BufferedReader uin = new BufferedReader(new InputStreamReader(in));
		String line, request="";
		try {
			while((line = uin.readLine())!=null){
				request = request + line + "\n";
				if(line.indexOf("</object>") > -1) {
					request = request + "</java>";
					break;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//InputStream�� InvocationContext�� XMLDecoding...
		XMLDecoder decoder = new XMLDecoder(new ByteArrayInputStream(request.getBytes()));
		InvocationContext invokeContext = (InvocationContext)decoder.readObject();
		
		try {
			Class cls;
			Object serviceObject;
			serviceObject = serviceRepository.get(invokeContext.getServiceName());
			cls = serviceObject.getClass();
			
			Class[] parameterTypeList = new Class[invokeContext.getArguments()!=null ? invokeContext.getArguments().length : 0];
			for(int i=0; i<parameterTypeList.length; i++)
				parameterTypeList[i] = invokeContext.getArguments()[i].getClass();
			
			Method method = cls.getMethod(invokeContext.getMethodName(), parameterTypeList);
			Object result = method.invoke(serviceObject, invokeContext.getArguments());
			
			XMLEncoder encoder = new XMLEncoder(out);
			encoder.writeObject(result);
			encoder.flush();
			encoder.close();
		
		} catch (Exception e) {
			e.printStackTrace();

		} 
		
	}
	
	public void registerServiceObject(String serviceName, Object serviceObject){
		serviceRepository.put(serviceName, serviceObject);
	}

	
	
	
//	------------------ For Client ----------------------//
	
	String serviceName;
	String ipAddress;

	public ApplicationServer(String ipAddress, String serviceName){
		this.serviceName = serviceName;
		this.ipAddress = ipAddress;
	}
	
	public static Object getRemoteObject(String ip, String serviceName, Class cls) throws Exception{
		
		return Proxy.newProxyInstance(
			ApplicationServer.class.getClassLoader(),
			new Class[]{cls},
			new ApplicationServer(ip, serviceName)
		);
	}
	
	public Object invoke(Object proxy, Method m, Object[] args)	throws Throwable{
		
		//InvocationContext�� serviceName, MethodName, arguments��...set
		InvocationContext invokeContext = new InvocationContext();   
		invokeContext.setServiceName(serviceName);
		invokeContext.setMethodName(m.getName());
		invokeContext.setArguments(args);
		
		Socket socket = new Socket(ipAddress, 8080);
		
		InputStream in = new DataInputStream(	new BufferedInputStream(socket.getInputStream()));
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

		//InvocationContext�� XML�� ���ڵ�...
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(invokeContext);
		encoder.flush();
		
		//XML�� decoding...
		XMLDecoder decoder = new XMLDecoder(in);
		Object returnedObjectFromServer = decoder.readObject();		
		
		encoder.close();
		decoder.close();
		
		return returnedObjectFromServer;
	}

}
