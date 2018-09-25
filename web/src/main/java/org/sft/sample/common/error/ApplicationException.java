package org.sft.sample.common.error;

public class ApplicationException extends RuntimeException {
	private ApplicationErrorCode errorCode;

	/**
	 * 
	 */
	private static final long serialVersionUID = 5346538083482939425L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(ApplicationErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ApplicationErrorCode getErrorCode() {
		return errorCode;
	}
	
}
