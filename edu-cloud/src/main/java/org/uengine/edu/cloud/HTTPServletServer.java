package org.uengine.edu.cloud;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class HTTPServletServer extends AbstractServer {

	@Override
	public void handleSession(InputStream in, OutputStream out) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = new String();
		String[] strTemp = new String[10];
		PrintWriter writer = new PrintWriter(out);
		try {
			str = new String(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(str," ");
		int count = st.countTokens();
		for(int i = 0; i < count;i++){
			strTemp[i] = st.nextToken();
		}
		String[] str2 = strTemp[1].split("[/]");
		strTemp = str2[1].split("[?]");
		String classname = strTemp[0];
		str2 = strTemp[1].split("[=]");
		String var = str2[1];
		
		try {
			Class c = Class.forName(classname);
			Method[] m = c.getDeclaredMethods();
			Object o = c.newInstance();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			ServletRequest request = new SimpleServletRequest(in, var);
			ServletResponse response = new SimpleServletResponse(buffer);
			
			
			m[0].invoke(o, request,response);
			buffer.flush();

			writer.println("HTTP/1.1 200 OK");
			writer.println("Date: Fri, 31 Dec 1999 23:59:59 GMT");
			writer.println("Content-Type: text/html");
			writer.println("Content-Length: "+(buffer.size()));
			writer.println("");

			writer.println(buffer.toString());
			
			writer.println("");
			
			writer.flush();

			System.out.println("sent.");
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		PrintWriter pw = new PrintWriter(out);
		pw.println("HTTP/1.1 200 OK");
		pw.println("Date: Fri, 31 Dec 1999 23:59:59 GMT");
		pw.println("Content-Type: text/html");
		pw.println("Content-Length: 3");
		pw.println("");
		pw.println("ABC");
		pw.flush();
		*/
		
	}
	
	public static void main(String[] args) throws Exception{
		
		HTTPServletServer hs = new HTTPServletServer();
		hs.openServer(8181);
		
	}
	
	class SimpleServletRequest implements HttpServletRequest {
		
		InputStream inputStream;
		Map parameterMap;
		String query;
		
		public SimpleServletRequest(InputStream in, String value){
			inputStream = in;
			query = value;
			parameterMap = new HashMap();
			
			parameterMap.put("name", query);			
		}

		public String getAuthType() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getContextPath() {
			// TODO Auto-generated method stub
			return null;
		}

		public Cookie[] getCookies() {
			// TODO Auto-generated method stub
			return null;
		}

		public long getDateHeader(String arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getHeader(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Enumeration getHeaderNames() {
			// TODO Auto-generated method stub
			return null;
		}

		public Enumeration getHeaders(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public int getIntHeader(String arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getMethod() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getPathInfo() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getPathTranslated() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getQueryString() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getRemoteUser() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getRequestURI() {
			// TODO Auto-generated method stub
			return null;
		}

		public StringBuffer getRequestURL() {
			// TODO Auto-generated method stub
			return new StringBuffer();
		}

		public String getRequestedSessionId() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getServletPath() {
			// TODO Auto-generated method stub
			return null;
		}

		public HttpSession getSession() {
			// TODO Auto-generated method stub
			return null;
		}

		public String changeSessionId() {
			return null;
		}

		public HttpSession getSession(boolean arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Principal getUserPrincipal() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isRequestedSessionIdFromCookie() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isRequestedSessionIdFromURL() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isRequestedSessionIdFromUrl() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean authenticate(HttpServletResponse httpServletResponse) throws IOException, ServletException {
			return false;
		}

		public void login(String s, String s1) throws ServletException {

		}

		public void logout() throws ServletException {

		}

		public Collection<Part> getParts() throws IOException, ServletException {
			return null;
		}

		public Part getPart(String s) throws IOException, ServletException {
			return null;
		}

		public <T extends HttpUpgradeHandler> T upgrade(Class<T> aClass) throws IOException, ServletException {
			return null;
		}

		public boolean isRequestedSessionIdValid() {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean isUserInRole(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public Object getAttribute(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Enumeration getAttributeNames() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getCharacterEncoding() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getContentLength() {
			// TODO Auto-generated method stub
			return 0;
		}


		public long getContentLengthLong() {
			return 0;
		}

		public String getContentType() {
			// TODO Auto-generated method stub
			return "text/html";
		}

		public ServletInputStream getInputStream() throws IOException {
			// TODO Auto-generated method stub
			ServletInputStream servletInputStream = new ServletInputStream(){

				public boolean isFinished() {
					return false;
				}

				public boolean isReady() {
					return false;
				}

				public void setReadListener(ReadListener readListener) {

				}

				public int read() throws IOException {
					return inputStream.read();
				}
				
			};
			
			return null;
		}

		public Locale getLocale() {
			// TODO Auto-generated method stub
			return new Locale("ko", "KR");
		}

		public Enumeration getLocales() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getParameter(String arg0) {
			// TODO Auto-generated method stub
			return (String)parameterMap.get(arg0);
		}

		public Map getParameterMap() {
			// TODO Auto-generated method stub
			return null;
		}

		public Enumeration getParameterNames() {
			// TODO Auto-generated method stub
			return null;
		}

		public String[] getParameterValues(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getProtocol() {
			// TODO Auto-generated method stub
			return null;
		}

		public BufferedReader getReader() throws IOException {
			// TODO Auto-generated method stub
			return new BufferedReader(new InputStreamReader(inputStream));
		}

		public String getRealPath(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public int getRemotePort() {
			return 0;
		}

		public String getLocalName() {
			return null;
		}

		public String getLocalAddr() {
			return null;
		}

		public int getLocalPort() {
			return 0;
		}

		public ServletContext getServletContext() {
			return null;
		}

	
		public AsyncContext startAsync() throws IllegalStateException {
			return null;
		}

		public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
			return null;
		}

		public boolean isAsyncStarted() {
			return false;
		}

		public boolean isAsyncSupported() {
			return false;
		}

		public AsyncContext getAsyncContext() {
			return null;
		}

		public DispatcherType getDispatcherType() {
			return null;
		}

		public String getRemoteAddr() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getRemoteHost() {
			// TODO Auto-generated method stub
			return null;
		}

		public RequestDispatcher getRequestDispatcher(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String getScheme() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getServerName() {
			// TODO Auto-generated method stub
			return null;
		}

		public int getServerPort() {
			// TODO Auto-generated method stub
			return 0;
		}

		public boolean isSecure() {
			// TODO Auto-generated method stub
			return false;
		}

		public void removeAttribute(String arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setAttribute(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			
		}
	}
	
	class SimpleServletResponse implements HttpServletResponse {
		
		OutputStream outputStream;
		
		public SimpleServletResponse(OutputStream out){
			
			outputStream = out;
		}

		public void addCookie(Cookie arg0) {
			// TODO Auto-generated method stub
			
		}

		public void addDateHeader(String arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}

		public void addHeader(String arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}

		public void addIntHeader(String arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		public boolean containsHeader(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		public String encodeRedirectURL(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String encodeRedirectUrl(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String encodeURL(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public String encodeUrl(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public void sendError(int arg0) throws IOException {
			// TODO Auto-generated method stub
			
		}

		public void sendError(int arg0, String arg1) throws IOException {
			// TODO Auto-generated method stub
			
		}

		public void sendRedirect(String arg0) throws IOException {
			// TODO Auto-generated method stub
			
		}

		public void setDateHeader(String arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setHeader(String arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setIntHeader(String arg0, int arg1) {
			// TODO Auto-generated method stub
			
		}

		public void setStatus(int arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setStatus(int arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}

		public int getStatus() {
			return 0;
		}

		public String getHeader(String s) {
			return null;
		}

		public Collection<String> getHeaders(String s) {
			return null;
		}

		public Collection<String> getHeaderNames() {
			return null;
		}

		public void flushBuffer() throws IOException {
			// TODO Auto-generated method stub
			
		}

		public int getBufferSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getCharacterEncoding() {
			// TODO Auto-generated method stub
			return "EUC-KR";
		}

	
		public String getContentType() {
			return null;
		}

		public Locale getLocale() {
			// TODO Auto-generated method stub
			return null;
		}

		public ServletOutputStream getOutputStream() throws IOException {
			// TODO Auto-generated method stub
			ServletOutputStream servletOutputStream = new ServletOutputStream(){

				public boolean isReady() {
					return false;
				}

				public void setWriteListener(WriteListener writeListener) {

				}

				public void write(int b) throws IOException {
					outputStream.write(b);
				}
				
			};

			return servletOutputStream;
			
		}

		public PrintWriter getWriter() throws IOException {
			// TODO Auto-generated method stub
			return null;
		}

		public void setCharacterEncoding(String s) {

		}

		public boolean isCommitted() {
			// TODO Auto-generated method stub
			return false;
		}

		public void reset() {
			// TODO Auto-generated method stub
			
		}

		public void resetBuffer() {
			// TODO Auto-generated method stub
			
		}

		public void setBufferSize(int arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setContentLength(int arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setContentLengthLong(long l) {

		}

		public void setContentType(String arg0) {
			// TODO Auto-generated method stub
			
		}

		public void setLocale(Locale arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
