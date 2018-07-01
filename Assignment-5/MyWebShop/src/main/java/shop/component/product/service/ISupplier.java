package shop.component.product.service;

import java.util.List;

import shop.component.product.domain.Supplier;
import shop.component.product.domain.SupplierAddress;

public interface ISupplier {
	public void addSupplier(String supplierId, String name, String phone,
			String email, SupplierAddress supplierAddress);
	public Supplier getSupplier(String supplierId);
	public List<Supplier> getAllSupplier();
}
