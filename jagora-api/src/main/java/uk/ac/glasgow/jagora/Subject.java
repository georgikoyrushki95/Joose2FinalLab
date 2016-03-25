package uk.ac.glasgow.jagora;


public interface Subject {
	
	public void registerObserver(Trader o);
	public void removeObserver(Trader o);
	public void notifyObservers();
	
}
