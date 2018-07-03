package shop.component.order.dto;

import java.time.LocalDate;

public class CreditCardDto {
	String cardName;
	String cardNumber;
	LocalDate validTill;
public CreditCardDto() {
	
}
	public CreditCardDto(String cardName, String cardNumber, LocalDate validTill) {
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
