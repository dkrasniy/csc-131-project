import java.util.Date;
import java.util.function.DoubleBinaryOperator;

public class Stock
{
    String ticker;
    double purchaseprice;
    int shares;
    Date date;

    public Stock(String ticker, double purchaseprice, int shares, Date date)
    {
        this.ticker = ticker;
        this.purchaseprice = purchaseprice;
        this.shares = shares;
        this.date = date;
    }

    public String getTicker()
    {
        return ticker;
    }

    public Double getPurchasePrice()
    {
        return purchaseprice;
    }
    public int getShares()
    {
        return shares;
    }



}