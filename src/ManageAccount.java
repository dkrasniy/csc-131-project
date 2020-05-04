//ManageAccount will execute functions such as sell, buy tickers

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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

    public static int ReturnIndexOfItemFromTicker(ArrayList<Stock> myAccount, String ticker)  {
        for (int i = 0; i < myAccount.size(); i++) {
            if (myAccount.get(i).getTicker().contains(ticker)) {
                return i;
            }
        }
        return 0;
    }
    public static void buyShares(ArrayList<Stock> myAccount) throws IOException{
        System.out.println("Which stock would you like to BUY? Enter ticker symbol (e.g. AAPL, TSLA)");
        Scanner buyInputScanner = new Scanner(System.in);
        String ticker = buyInputScanner.nextLine();


        boolean alreadyOwnsTicker = myAccount.stream().anyMatch(o -> o.getTicker().equals(ticker));
        if(alreadyOwnsTicker) {
            System.out.println();
            System.out.print("You already own " + ticker + " stock. How many additional shares would you like to purchase at $");
        } else {
            System.out.println();
            System.out.print("How many shares of " + ticker + " would you like to buy? It is currently trading at $" );
        }

        double currentPrice = StockInfo.ReturnStockPrice(ticker);
        System.out.println(currentPrice);

        int sharesAmount = buyInputScanner.nextInt();
        System.out.print(sharesAmount);

        //add to account
        Date date = new Date();



        if(alreadyOwnsTicker) {
            //add new shares to existing shares
            int existingShares = myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).getShares();
            myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).setShares(existingShares + sharesAmount);

            //avg purchase price
            Double existingPrice = myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).getPurchasePrice();
            myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).setPurchasePrice((existingPrice + currentPrice)/2);

            System.out.println();
            System.out.print("Success! You now have ");
            System.out.print(existingShares + sharesAmount);
            System.out.println(" shares of " + ticker + " total!");

        } else {
            myAccount.add(new Stock (ticker, currentPrice, sharesAmount, date));
            System.out.println(" shares of " + ticker + " have been purchased!");
        }
    }

    /* allows the user to select a stock they want to sell */
    public static void sellShares(ArrayList<Stock> myAccount){
        System.out.println("Which stock would you like to SELL? Enter ticker symbol (e.g. AAPL, TSLA)");
        Scanner buyInputScanner = new Scanner(System.in);
        String ticker = buyInputScanner.nextLine();

        System.out.print("How many shares of " + ticker + " would you like to SELL? You have.... shares" );
    }


}
