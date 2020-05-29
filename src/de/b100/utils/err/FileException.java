package de.b100.utils.err;

public class FileException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public FileException() {
		super();
	}
	
	public FileException(String message) {
		super(message);
	}
	
	public FileException(Exception e) {
		super(e);
	}

}
