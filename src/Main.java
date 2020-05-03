import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String args[]) throws IOException {

        int STARTING_BALANCE = 50000;

        Stock aapl = new Stock("AAPL",294.23);

        ArrayList<Stock> myAccount = new ArrayList<Stock>();

        System.out.println("Hello, your starting balance is $" + STARTING_BALANCE);
        System.out.println("What would you like to do today?");
        System.out.println("Type b to buy");
        System.out.println("Type s to sell");
        System.out.println("Type a to view account details");

        ManageAccount.add(4,7);
        System.out.print(StockInfo.ReturnStockPrice("AAPL"));
    }
}
