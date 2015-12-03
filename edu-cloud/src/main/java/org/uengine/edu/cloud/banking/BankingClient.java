package org.uengine.edu.cloud.banking;

import org.uengine.edu.cloud.ApplicationServer;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class BankingClient {

    public static void main(String... args) throws Exception {
        IBanking remoteBank = (IBanking) new BankingService();//ApplicationServer.getRemoteObject("127.0.0.1", "Banking", IBanking.class);
        int balance = remoteBank.deposit(100);
        System.out.println(" Client called Deposit...");

        System.out.println(balance);

    }
}
