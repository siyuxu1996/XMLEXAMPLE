package pkgLibrary;

public class BookException extends Exception{
	public BookException(String exc){
		super(exc);
	}
	
	public String getMessage(){
		return super.getMessage();
	}
}
