package shop.message;

public class NotFoundMessage {
	String errorMessage;

	public NotFoundMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
