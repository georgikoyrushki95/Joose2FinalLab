package uk.ac.glasgow.jagora.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.ac.glasgow.jagora.Stock;
import uk.ac.glasgow.jagora.StockExchange;
import uk.ac.glasgow.jagora.TickEvent;
import uk.ac.glasgow.jagora.Trade;

/**
 * Implements the behaviour of a passive default trader who never makes bids or
 * offers on the market.
 * 
 * @author tws
 *
 */
public class DefaultTrader extends AbstractTrader {
	
	public DefaultTrader(String name, Double cash, Stock stock, Integer quantity) {
		super(name, cash, createInventory(stock, quantity));
	}

	private static Map<Stock, Integer> createInventory(Stock stock, int quantity) {
		Map<Stock,Integer> inventory = new HashMap<Stock,Integer>();
		inventory.put(stock, quantity);
		return inventory;
	}

	@Override
	public void speak(StockExchange stockExchange) {
		//Does nothing.
	}
	
	
	//method from the Observer design pattern ( if a given trader registers for the stock exchange when he is created, 
	// he is eligible to receive updates )
	@Override
	public void update(List<TickEvent<Trade>> tradeHistory) {
		// TODO Auto-generated method stub
		
	}
}
