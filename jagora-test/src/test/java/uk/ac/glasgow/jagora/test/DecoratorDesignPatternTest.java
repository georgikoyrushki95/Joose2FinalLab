package uk.ac.glasgow.jagora.test;

import org.junit.Ignore;
import org.junit.Test;

import uk.ac.glasgow.jagora.BuyOrder;
import uk.ac.glasgow.jagora.SellOrder;
import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.Trader;
import uk.ac.glasgow.jagora.test.stub.StubObservingTrader;
import static uk.ac.glasgow.jagora.test.stub.StubStock.lemons;

import static org.junit.Assert.assertEquals;

@Ignore
public class DecoratorDesignPatternTest {
	
	protected StubObservingTrader trader;
	protected StockExchange theStockExchange;
	protected SellOrder sellOrder1;
	protected SellOrder sellOrder2;
	protected BuyOrder buyOrder1;
	protected BuyOrder buyOrder2;
	protected Stock theStock;
	
	//Note that thus we will also test whether placeSell/BuyOrder methods work
	@Test
	public void testGetBestBidAndOffer(){
		assertEquals(2.5, trader.subscriber.getBestBid(theStock), 0.0);
		assertEquals(0.2, trader.subscriber.getBestOffer(theStock), 0.0);
	}
	
	@Test
	public void testCancelBuyAndSellOrder(){
		trader.subscriber.cancelBuyOrder(buyOrder1);
		trader.subscriber.cancelSellOrder(sellOrder1);
		//making sure the orders we cancelled are no longer in the MarketBooks
		assertEquals(1.0, trader.subscriber.getBestBid(lemons), 0.0);
		assertEquals(0.5, trader.subscriber.getBestOffer(lemons), 0.0);
	}
	
}





