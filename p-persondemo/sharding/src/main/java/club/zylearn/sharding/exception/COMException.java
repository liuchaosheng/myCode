package club.zylearn.sharding.exception;

public class COMException extends Exception {
	private static final String COM_HEADER = "[COMException] ";
	private String message;
	public COMException() {
	}
	public COMException(String messge) {
		super(messge);
		this.message = messge;
	}
	public COMException(String message,Throwable cause) {
		super(message, cause);
	}
	@Override
	public String toString() {
		return COM_HEADER + message;
	}
}
