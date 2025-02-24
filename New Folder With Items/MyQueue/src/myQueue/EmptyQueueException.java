package myQueue;

public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException() {
		super();
	}
	public EmptyQueueException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 6150721124502716864L;

}
