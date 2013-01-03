package mx.com.magmasoft.satp.exception;

public class ParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6722255345454900204L;
	
	public ParseException(){
		super();
	}
	
	public ParseException(String message){
		super(message);
	}
	
	public ParseException(Throwable throwable){
		super(throwable);
	}
	
	public ParseException(String message, Throwable throwable){
		super(message, throwable);
	}

}
