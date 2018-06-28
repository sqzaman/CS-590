package swa.lab3.problem3.message;

public class SuccessMessage {
	String message;
	String identifier;
	public SuccessMessage(String message) {
		this.message = message;
	}

	public SuccessMessage(String message, String identifier) {
		this.message = message;
		this.identifier = identifier;
	}
	public String getMessage() {
		return message;
	}

	public String getIdentifier() {
		return identifier;
	}

	
}
