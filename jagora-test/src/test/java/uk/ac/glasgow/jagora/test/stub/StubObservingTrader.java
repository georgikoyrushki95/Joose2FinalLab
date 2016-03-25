package uk.ac.glasgow.jagora.test.stub;

import java.util.List;
import java.util.Set;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;
import uk.ac.glasgow.jagora.TradeException;
import  uk.ac.glasgow.jagora.Trader;

public class StubObservingTrader implements Trader {
		
	private StockExchange subscriber;
	/* Would like to have public acces to the tradeHistory for testing purposes.
	 * Regardless, the list should be modifiable, so it would make no difference */
	public List<TickEvent<Trade>> tradeHistory = null;
	private String name;
	
	public StubObservingTrader(StockExchange subscriber, String name) {
		this.subscriber = subscriber;
		//register this trader with the subscriber
		subscriber.registerObserver(this);
		this.name = name;
	}	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Double getCash() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sellStock(Stock stock, Integer quantity, Double price) throws TradeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyStock(Stock stock, Integer quantity, Double price) throws TradeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getInventoryHolding(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void speak(StockExchange stockExchange) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Stock> getTradingStocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(List<TickEvent<Trade>> tradeHistory) {
		this.tradeHistory = tradeHistory;
	}
	
	
	
}
