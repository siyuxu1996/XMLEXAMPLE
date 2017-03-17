
package pkgLibrary;

public class BookException extends Exception
{
	private Book d;
	
	public BookException()
	{
		super();
	}
	
	public BookException(Book b)
	{
		super();
		this.d = b;
	}
	
}