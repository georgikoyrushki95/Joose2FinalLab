package uk.ac.glasgow.jagora;

import java.util.List;


/**
 * Defines the behaviour of a stock exchange on which a variety of stocks can be
 * traded using different types of buy and sell orders.
 * 
 * @author tws
 *
 */
public interface StockExchange extends Tradable{

	/**
	 * Performs clearing on all stock markets hosted by this exchange. Clearing
	 * will proceed until no further trades are possible.
	 */
	public void doClearing ();
	
	/**
	 * 
	 * @param stock
	 * @return an ordered (by execution) list of tick events for the trades that
	 *         have occurred since initiation for the specified stock on this
	 *         exchange.
	 */
	public List<TickEvent<Trade>> getTradeHistory(Stock stock);


}
