package shop.component.product.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupplierDto {
	@Id
	String supplierId;
	String name;
	String phone;
	String email;
	SupplierAddressDto supplierAddressDto;
	public SupplierDto(String supplierId, String name, String phone, String email, SupplierAddressDto supplierAddressDto) {
		this.supplierId = supplierId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.supplierAddressDto = supplierAddressDto;
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
	public SupplierAddressDto getSupplierAddressDto() {
		return supplierAddressDto;
	}
	public void setSupplierAddress(SupplierAddressDto supplierAddressDto) {
		this.supplierAddressDto = supplierAddressDto;
	}	
}
