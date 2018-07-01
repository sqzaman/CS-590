package shop.component.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.component.product.domain.Supplier;
import shop.component.product.domain.SupplierAddress;
import shop.component.product.domain.service.SuppierDomainService;
import shop.component.product.dto.SupplierAddressDto;
import shop.component.product.dto.SupplierDto;
import shop.component.product.repository.SupplierRepository;
import shop.component.product.service.ISupplier;

@Service
public class SupplierService implements ISupplier {
	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	SuppierDomainService suppierDomainService;

	@Override
	public Supplier getSupplier(String supplierId) {
		return supplierRepository.findById(supplierId).orElse(null);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return supplierRepository.findAll();
	}

	@Override
	public void addSupplier(String supplierId, String name, String phone, String email,
			SupplierAddress supplierAddress) {
		supplierRepository.save(suppierDomainService.createSupplier(supplierId, name, phone, email, supplierAddress));
	}

	public SupplierDto addSupplier(SupplierDto supplierDto) {
		this.addSupplier(supplierDto.getSupplierId(), supplierDto.getName(), supplierDto.getPhone(),
				supplierDto.getEmail(),
				new SupplierAddress(supplierDto.getSupplierAddressDto().getStreet(),
						supplierDto.getSupplierAddressDto().getCity(), supplierDto.getSupplierAddressDto().getZip(),
						supplierDto.getSupplierAddressDto().getCountry()));
		return supplierDto;
	}

	public SupplierDto getSupplierDto(String supplierId) {
		Supplier supplier = this.getSupplier(supplierId);
		return new SupplierDto(supplier.getSupplierId(), supplier.getName(), supplier.getPhone(), supplier.getEmail(),
				new SupplierAddressDto(supplier.getSupplierAddress().getStreet(),
						supplier.getSupplierAddress().getCity(), supplier.getSupplierAddress().getZip(),
						supplier.getSupplierAddress().getCountry()));
	}

	public List<SupplierDto> getAllSupplierDto() {
		List<Supplier> suppliers = this.getAllSupplier();
		List<SupplierDto> suppliersDto = new ArrayList<>();
		suppliers.forEach((s) -> {
			suppliersDto.add(new SupplierDto(s.getSupplierId(), s.getName(), s.getPhone(), s.getEmail(),
					new SupplierAddressDto(s.getSupplierAddress().getStreet(), s.getSupplierAddress().getCity(),
							s.getSupplierAddress().getZip(), s.getSupplierAddress().getCountry())));
		});

		return suppliersDto;
	}

}
