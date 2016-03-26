import java.util.HashMap;

public class TestMultipleParams {
	
	public HashMap<String, Integer> freq;
	Integer quantity;
	
	public TestMultipleParams(Integer quantity, Object...stockPrice) {
		this.quantity = quantity;
		freq = new HashMap<String, Integer>();
		for (int i = 0; i < stockPrice.length; i+=2){
			freq.put((String)stockPrice[i], (Integer)stockPrice[i + 1]); 
		}
	}
	
	public static void main(String[] args) {
		Integer quantity = 5;
		Object[] stockPrice = {"Gay", 1, "Pederast" , 2, "Lemons", 3};
		TestMultipleParams test = new TestMultipleParams(quantity, stockPrice);
	}
	
}
