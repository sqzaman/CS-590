package shop.component.order.domain;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class OrderCreditCard {
	String cardName;
	String cardNumber;

	public OrderCreditCard(String cardName, String cardNumber) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}


}
