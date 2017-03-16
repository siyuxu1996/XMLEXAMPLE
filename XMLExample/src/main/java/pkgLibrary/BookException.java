package pkgLibrary;

public class BookException extends Exception {
	private Book b;
	
	public BookException(){
		super();
	}
	
	public BookException(Book b){
		super("Error");
		this.b = b;
	}

}