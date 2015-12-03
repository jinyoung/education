package org.uengine.edu.cloud;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class HttpServer extends AbstractServer{
    @Override
    public void handleSession(InputStream in, OutputStream out) {
        PrintWriter pw = new PrintWriter(out);
        pw.println("HTTP/1.1 200 OK");
        pw.println("Date: Fri, 31 Dec 1999 23:59:59 GMT");
        pw.println("Content-Type: text/html");
        pw.println("Content-Length: 3");
        pw.println("");
        pw.println("DEF");
        pw.flush();
    }

    public static void main(String... args) throws Exception {
        new HttpServer().openServer(8080);
    }
}
