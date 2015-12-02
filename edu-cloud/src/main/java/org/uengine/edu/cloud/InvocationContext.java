package org.uengine.edu.cloud;

public class InvocationContext {

    private String serviceName;
    private String methodName;
    private Object[] arguments;

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
