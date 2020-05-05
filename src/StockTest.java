//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import java.util.Date;

import org.junit.jupiter.api.Test;

class StockTest {

	@Test
	void getShares() {
		Date date = new Date();
		Stock test = new Stock("b", 35.5, 12, date);
		int purchasedShares = 12;
		
		assertEquals("getShares()", purchasedShares, test.getShares());
	}
	
	@Test
	void getPurchasePrice() {
		Date date = new Date();
		Stock test = new Stock("b", 35.5, 12, date);
		double purchasedPrice = 35.5;
		
		assertEquals("getPurchasedPrice()", purchasedPrice, test.getPurchasePrice(), .01);
		
	}
	
	@Test
	void getTicker() {
		Date date = new Date();
		Stock test = new Stock("AAPL", 293.16, 12, date);
		String ticker = "AAPL";
		
		assertEquals("getTicker()", ticker, test.getTicker());
	}

}
