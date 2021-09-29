package org.uengine.edu.cloud.banking;

import org.uengine.edu.cloud.ApplicationServer;

/**
 * Created by jjy on 2015. 12. 2..
 */
public class BankingService implements IBanking{
    int balance = 0;

    public int deposit(int money) {
        balance = balance + money;

        return balance;
    }

    public static void  main(String... args) throws Exception {
        ApplicationServer applicationServer = new ApplicationServer(null, null);
        applicationServer.registerServiceObject("Banking", new BankingService());
        applicationServer.openServer(9090);

    }
}
