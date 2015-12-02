package org.uengine.edu.cloud;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AbstractServer {

    public void openServer(int thePort) throws Exception {

        ServerSocket server = new ServerSocket(thePort);

        while (true) {
            Socket socket = server.accept();

            final InputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            final OutputStream out = new BufferedOutputStream(socket.getOutputStream());

            Thread sessionHandlingThread = new Thread() {

                public void run() {
                    handleSession(in, out);
                }

            };

            sessionHandlingThread.start();
        }
    }

    public abstract void handleSession(InputStream in, OutputStream out);
}