import java.util.Date;
import java.util.function.DoubleBinaryOperator;

public class Stock
{
    String ticker;
    double price;
    int shares;
    Date date;

    public Stock(String ticker, double price)
    {
        this.ticker = ticker;
        this.price = price;
        this.shares = shares;
        this.date = date;
    }

    public String getTicker()
    {
        return ticker;
    }

    public Double getPrice()
    {
        return price;
    }
    public int getShares()
    {
        return shares;
    }



}