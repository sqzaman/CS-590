package shop.component.customer.domain;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CreditCard {
	String cardName;
	String cardNumber;
	LocalDate validTill;

	public CreditCard(String cardName, String cardNumber, LocalDate validTill) {
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.validTill = validTill;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public LocalDate getValidTill() {
		return validTill;
	}

}
