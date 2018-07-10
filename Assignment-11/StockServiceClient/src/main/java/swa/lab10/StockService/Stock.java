package swa.lab10.StockService;

public class Stock {
	private int productId;
	public Stock(int productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	private int quantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	
}
