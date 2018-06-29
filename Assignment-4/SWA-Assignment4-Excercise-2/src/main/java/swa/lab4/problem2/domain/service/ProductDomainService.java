package swa.lab4.problem2.domain.service;

import org.springframework.stereotype.Service;

import swa.lab4.problem2.domain.entity.valueobject.Stock;

@Service
public class ProductDomainService {

	public Stock getStockObject( int quantity, String locationCode) {;
		return new Stock(locationCode, quantity);
	}
}
