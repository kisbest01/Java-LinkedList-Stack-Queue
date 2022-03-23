
/**
 * Product class
 * @author HK
 *
 */
public class Product implements java.io.Serializable {
	String bcode;
	String title;
	Integer quantity;
	double price;
	
	/**
	 * Default constructor
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor method to initialize a product
	 * 
	 * @param bcode		Product's bar code
	 * @param title		Product's title
	 * @param quantity	Product's quantity
	 * @param price		Product's price
	 */
	public Product(String bcode, String title, Integer quantity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Convert this product to String for printing
	 */
	@Override
	public String toString() {
		while (bcode.length() < 3) {
			bcode += " ";
		}
		while (title.length() < 7) {
			title += " ";
		}
		String qt = "   " + quantity;
		while (qt.length() < 8) {
			qt += " ";
		}
		return " " + bcode + " | " + title + " | " + qt + " | " + price;
	}
}