package shop.component.order.dto;

public class CartItemDto {
	private ProductDto product;
	private int quantity;
	
	public CartItemDto() {		
	}
	
	public ProductDto getProduct() {
		return product;
	}
	public void setProduct(ProductDto product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
