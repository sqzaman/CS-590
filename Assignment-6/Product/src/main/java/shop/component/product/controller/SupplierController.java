package shop.component.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.component.product.dto.SupplierDto;
import shop.component.product.service.impl.SupplierService;
import shop.message.NotFoundMessage;
import shop.message.SuccessMessage;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@PostMapping("/add")
	public ResponseEntity<?> addSupplier(@RequestBody SupplierDto supplierDto) {
		supplierService.addSupplier(supplierDto);
		return new ResponseEntity<SuccessMessage>(new SuccessMessage("Successfully added"), HttpStatus.OK);
	}

	@GetMapping("/get/{supplierId}")
	public ResponseEntity<?> getSupplier(@PathVariable("supplierId") String supplierId) {
		SupplierDto supplierDto = supplierService.getSupplierDto(supplierId);
		if (supplierDto != null)
			return new ResponseEntity<SupplierDto>(supplierDto, HttpStatus.OK);
		else
			return new ResponseEntity<NotFoundMessage>(new NotFoundMessage("no product found"), HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<SupplierDto>> getAllProducts() {
		return new ResponseEntity<List<SupplierDto>>(supplierService.getAllSupplierDto(), HttpStatus.OK);
	}
}
