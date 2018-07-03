package shop.component.product.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Supplier {
	@Id
	String supplierId;
	String name;
	String phone;
	String email;
	SupplierAddress supplierAddress;
	public Supplier(String supplierId, String name, String phone, String email, SupplierAddress supplierAddress) {
		this.supplierId = supplierId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SupplierAddress getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(SupplierAddress supplierAddress) {
		this.supplierAddress = supplierAddress;
	}	
}
