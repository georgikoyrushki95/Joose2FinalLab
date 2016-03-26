package uk.ac.glasgow.jagora.test;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.TradeException;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.impl.DefaultTrader;
import uk.ac.glasgow.jagora.impl.RandomTrader;
import uk.ac.glasgow.jagora.test.stub.StubStockExchange;

import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
/***
 * 
 * @author georgi
 *	Reusing the code from TraderTest and RandomTraderTest to test the functionality
 *	of the builder pattern
 */
@Ignore
public class BuilderPatternTest{
	
	protected Stock stock;
	protected Integer quantity;
	protected Double cash;
	protected String name;
	
	protected Trader randTrader;
	protected Trader defTrader;
	
	@Test
	public void testSpeak (){
		StubStockExchange stockExchange = new StubStockExchange();
		
		for (int i = 0 ; i < 20 ; i ++){
			randTrader.speak(stockExchange);
		}
		
		Double averageBuyPrice =
			stockExchange.buyOrders
				.stream()
				.mapToDouble(buyOrder->buyOrder.getPrice())
				.average()
				.getAsDouble();
		
		assertEquals(5.0, averageBuyPrice, 1.0);
		
		Double averageSellPrice =
			stockExchange.sellOrders
				.stream()
				.mapToDouble(buyOrder->buyOrder.getPrice())
				.average()
				.getAsDouble();

		assertEquals(5.0, averageSellPrice, 1.0);
	}
	
	@Test
	public void testGetName (){
		assertEquals(name,defTrader.getName());
	}
	
	@Test
	public void testGetCash (){
		assertEquals(cash, defTrader.getCash(), 0.0);
	}

	@Test
	public void testGetInventoryHolding (){
		assertEquals(quantity.intValue(), defTrader.getInventoryHolding(stock).intValue());
	}
	
	@Test
	public void testGetTradingStocks (){
		Set<Stock> expected = new HashSet<Stock>();
		expected.add(stock);
		assertEquals(expected, defTrader.getTradingStocks());
	}
	
	@Test
	public void testBuyStock() throws Exception {
		Double initialCash = defTrader.getCash();
		Integer initialQuantity = defTrader.getInventoryHolding(stock);
		defTrader.buyStock(stock, 10, 50.0);
		assertEquals(initialCash - 500 , defTrader.getCash(), 0.0);
		assertEquals(initialQuantity + 10, defTrader.getInventoryHolding(stock).intValue());
	}
	
	@Test
	public void testSellStock() throws Exception {
		Double initialCash = defTrader.getCash();
		Integer initialQuantity = defTrader.getInventoryHolding(stock);
		defTrader.sellStock(stock, 10, 50.0);
		assertEquals(initialCash + 500.0, defTrader.getCash(), 0.0);
		assertEquals(initialQuantity - 10, defTrader.getInventoryHolding(stock).intValue());
	}
	
	@Test(expected=TradeException.class)
	public void testBadBuyStock()  throws Exception {
		defTrader.buyStock(stock, 2, cash);
	}
	
	@Test(expected=TradeException.class)
	public void testBadBuyStockAtLimit()  throws Exception {
		defTrader.buyStock(stock, 1, cash+0.01);
	}
	
	@Test(expected=TradeException.class)
	public void testBadSellStock() throws Exception {
		defTrader.sellStock(stock, quantity+1, 1.0);
	}
			
}
