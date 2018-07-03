package shop.component.order.dto;


public class ProductDto {
	
	String productId;
	String name;
	String description;
	double price;


	public ProductDto(String productId, String name, String description, double price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return String.format("Product Id:%s, Name:%s, Description:%s, Price:%", productId, name, description, price);
	}
}
