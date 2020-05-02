import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws IOException {
        System.out.print(ReturnStockPrice("AAPL"));
    }

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
}
