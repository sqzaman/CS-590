package swa.lab3.problem3.message;

public class NotFoundMessage {
	String errorMessage;

	public NotFoundMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
