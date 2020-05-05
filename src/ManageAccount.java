//ManageAccount will execute functions such as sell, buy tickers

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ManageAccount {
    //fixed errors in some print statements and format
    public static void printAccountOverview(ArrayList<Stock> myAccount, String user) throws IOException  {
        DecimalFormat df = new DecimalFormat("#,###.00");

        System.out.println("ACCOUNT OVERVIEW: " + user);
        System.out.println("ACCOUNT VALUE: " + df.format(StockInfo.ReturnTotalAccountValue(myAccount)));
        System.out.println("");
        System.out.println(String.format("%5s %5s %5s %5s %5s %5s %5s %5s %5s", "Ticker", "|", "Shares", "|", "Purc Price", "|", "Total Value", "|", "Gain/Loss"));
        System.out.println(String.format("%s", "--------------------------------------------------------------------------------"));



        System.out.println();

        for (int counter = 0; counter < myAccount.size(); counter++) {
            double profitPerShare = StockInfo.ReturnProfitPerShare(myAccount.get(counter).ticker, myAccount.get(counter).purchaseprice);
            double profitPerAllShares = profitPerShare * myAccount.get(counter).shares;
            double totalValueOfAllShares= myAccount.get(counter).shares * StockInfo.ReturnStockPrice(myAccount.get(counter).ticker);
            System.out.println(String.format("%6s %5s %6d %5s %10s %5s %10s %5s %10s", myAccount.get(counter).ticker, "|", myAccount.get(counter).shares, "|", "$" + df.format(myAccount.get(counter).purchaseprice), "|", "$" + df.format(totalValueOfAllShares),"|", "$" +df.format(profitPerAllShares)));
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
        Scanner sellInputScanner = new Scanner(System.in);
        String ticker = sellInputScanner.nextLine();

        boolean alreadyOwnsTicker = myAccount.stream().anyMatch(o -> o.getTicker().equals(ticker));

        if(alreadyOwnsTicker) {
            System.out.print("How many shares of " + ticker + " would you like to SELL? You have " );
            int existingShares = myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).getShares();
            System.out.println(existingShares + ".");

            int sharesSellAmount = sellInputScanner.nextInt();

            if(existingShares - sharesSellAmount < 1) {
                myAccount.remove(ReturnIndexOfItemFromTicker(myAccount, ticker));
            } else {
                myAccount.get(ReturnIndexOfItemFromTicker(myAccount, ticker)).setShares(existingShares - sharesSellAmount);
            }
            System.out.println();
            if(sharesSellAmount > existingShares){
                System.out.println("SOLD ALL shares! You have no more " + ticker + " stock.");
            } else {
                System.out.println("SOLD " + sharesSellAmount + " shares!");
                System.out.println("You have  " + (existingShares - sharesSellAmount) + " shares remaining.");
            }


        } else {
            System.out.println("You do not own any shares of " + ticker + ".");
        }

    }


}
