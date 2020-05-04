import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String args[]) throws IOException {
        String user = "DAVID KRASNIY";
        int STARTING_BALANCE = 50000;

        ArrayList<Stock> myAccount = new ArrayList<Stock>();

        ManageAccount.buyShares(myAccount);

        Date date = new Date();

        myAccount.add(new Stock ("AAPL",294.23,500, date));
        myAccount.add(new Stock ("TSLA",650.00,20, date));

        // prints the users account info
        ManageAccount.printAccountOverview(myAccount, user);

//        System.out.println("Hello, your starting balance is $" + STARTING_BALANCE);
//        System.out.println("What would you like to do today?");
//        System.out.println("Type b to buy");
//        System.out.println("Type s to sell");
//        System.out.println("Type a to view account details");

    // System.out.print(StockInfo.ReturnStockPrice("AAPL"));
    }
}
