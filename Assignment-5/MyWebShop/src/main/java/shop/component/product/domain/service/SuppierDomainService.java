package shop.component.product.domain.service;

import org.springframework.stereotype.Service;

import shop.component.product.domain.Product;
import shop.component.product.domain.Stock;
import shop.component.product.domain.Supplier;
import shop.component.product.domain.SupplierAddress;

@Service
public class SuppierDomainService {
	public Supplier createSupplier(String supplierId, String name, String phone, String email, SupplierAddress supplierAddress) {
		return new Supplier(supplierId, name, phone, email, supplierAddress);
	}
	public void setStock(Product product, String locationCode, int quantity) {
		product.setStock(new Stock(locationCode, quantity));
	}
}
