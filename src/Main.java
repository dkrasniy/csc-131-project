import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String args[]) throws IOException {
        String user = "DAVID";
        Date date = new Date();

        ArrayList<Stock> myAccount = new ArrayList<Stock>();
        myAccount.add(new Stock ("TSLA",950.00,200, date));
        runChoicesScript(myAccount, user);
    }

    public static void runChoicesScript(ArrayList<Stock> myAccount, String user) throws IOException  {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Type b to buy");
        System.out.println("Type s to sell");
        System.out.println("Type a to view account details");
        System.out.println();

        Scanner reader = new Scanner(System.in);
        String action = reader.next();


        switch (action) {
            case "a":
                ManageAccount.printAccountOverview(myAccount, user);
                runChoicesScript(myAccount, user);
                break;
            case "b":
                ManageAccount.buyShares(myAccount);
                runChoicesScript(myAccount, user);
                break;
            case "s":
                ManageAccount.sellShares(myAccount);
                runChoicesScript(myAccount, user);
                break;
            default:
                runChoicesScript(myAccount, user);
        }
    }
}
