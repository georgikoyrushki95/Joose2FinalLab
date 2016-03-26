package uk.ac.glasgow.jagora;

import java.util.List;

public interface Observer {
	/***
	 * 
	 * @param tradeHistory
	 * 
	 * @logic Whenever a Trader actually registers to get updates, he/she will get a complete list of the tradeHistory 
	 * from the StockExchange
	 */
	public void update(List<TickEvent<Trade>> tradeHistory);
}
