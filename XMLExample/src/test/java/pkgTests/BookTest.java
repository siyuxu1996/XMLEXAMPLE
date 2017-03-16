package pkgTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.BookException;

public class BookTest {

	@Test
	public void GetBookTest1() {
		Book b = new Book("bk100");
		assertTrue(b.GetBook("bk100").equals(b));
	}
	
	@Test
	public void GetBookTest2() {
		Book b = new Book("bk200");
		assertEquals(b.GetBook("bk200"), b);
	}
	
	/*
	  
	 Apparently Date(int, int, int) is "deprecated", so I 
	 just used Date() - which I believe gives current 
	 date and time - for testing AddBook()
	  
	 */
	
	
	@Test
	public void AddBookTest1() {
		Book b = new Book("bk123", "Louis Chevrolet", "Chevy is cool", "Cars", 200.00, 160.00, new Date(), "Chevys are the best");
		b.AddBook("bk123", b);
		assertEquals(b.GetBook("bk123"), b);
	}
	
	@Test
	public void AddBookTest2() {
		Book b = new Book("bk886", "Lucas Zlock", "I Love Computer Science", "Autobiography", 100.00, 80.00, new Date(), "Computers");
		b.AddBook("bk886", b);
		assertFalse(b.GetBook("bk0").equals(b));

	}
}