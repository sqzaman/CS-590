package shop.component.product.dto;

public class ShoppingProductDto {
	
	private String productId;
	private String name;
	private double price;


	
	public ShoppingProductDto(String productId, String name, double price) {
		this.productId = productId;		
		this.name = name;	
		this.price = price;			
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Product Id:%s, Name:%s, Price:%", productId, name, price);
	}
}
