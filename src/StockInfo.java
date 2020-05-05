//Stock info will return Company Info, Stock Price

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class StockInfo {
    public static Double ReturnStockPrice(String symbol) throws IOException {
        URL url = new URL("https://query1.finance.yahoo.com/v7/finance/spark?symbols=" + symbol);

        Scanner sc = new Scanner(url.openStream());

        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        String result = sb.toString();


        //search the returned json for the regularMarketPrice and get the price follwing :
        int p = result.indexOf("regularMarketPrice", 0);
        int from = result.indexOf(":", p);
        int to = result.indexOf(",", from);
        String price = result.substring(from + 1, to);

        return Double.parseDouble(price);
    }

    // returns profit from stock
    public static Double ReturnProfitPerShare(String ticker, double purchasePrice) throws IOException  {
        return ReturnStockPrice(ticker) - purchasePrice;
    }

    //added method to return account value
    public static Double ReturnTotalAccountValue(ArrayList<Stock> myAccount) throws IOException  {
        double totalAccountValue = 0;
        for (int counter = 0; counter < myAccount.size(); counter++) {
            totalAccountValue +=  (ReturnStockPrice(myAccount.get(counter).ticker) * myAccount.get(counter).shares);
        }
        return totalAccountValue;
    }


}
