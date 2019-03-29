package patterns;

public class EmailBuilder {

	private Email email;

	public EmailBuilder() {
		email = new Email();
	}

	public EmailBuilder setTo(String to) {
		email.setTo(to);
		return this;
	}

	public EmailBuilder setSubject(String subject) {
		email.setSubject(subject);
		return this;
	}

	public EmailBuilder setMessage(String message) {
		email.setMessage(message);
		return this;
	}

	public Email build() {
		return email;
	}
}
