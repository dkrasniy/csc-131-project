//ManageAccount will execute functions such as sell, buy tickers

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ManageAccount {
    public static void add(int a, int b) {
        int c = a + b;
        System.out.println(c);

    }
    public static void printAccountOverview(ArrayList<Stock> myAccount, String user) throws IOException  {
        System.out.println("ACCOUNT OVERVIEW: " + user);
        System.out.println("ACCOUNT VALUE: " + StockInfo.ReturnTotalAccountValue(myAccount));
        System.out.println("");
        System.out.println(String.format("%5s %5s %5s %5s %10s %5s %5s", "Ticker", "|", "Shares", "|", "Purchase Price", "|", "Gain/Loss"));
        System.out.println(String.format("%s", "--------------------------------------------------------"));

        for (int counter = 0; counter < myAccount.size(); counter++) {
            double profitPerShare = StockInfo.ReturnProfitPerShare(myAccount.get(counter).ticker, myAccount.get(counter).purchaseprice);
            double profitPerAllShares = profitPerShare * myAccount.get(counter).shares;
            System.out.println(String.format("%6s %5s %6d %5s %10.2f %5s %10.2f", myAccount.get(counter).ticker, "|", myAccount.get(counter).shares, "|", myAccount.get(counter).purchaseprice, "|", profitPerAllShares));

        }

    }

    public static void buyShares(ArrayList<Stock> myAccount){
        System.out.println("Which stock would you like to buy? Enter ticker symbol (e.g. AAPL, TSLA)");

    }


}
