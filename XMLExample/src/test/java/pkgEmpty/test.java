package pkgEmpty;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import pkgLibrary.Book;
import pkgLibrary.Catalog;


public class test {

	@Test
	public void getbook1() {
		Book a = new Book("bk101");
		assertTrue(a.getBook("bk101").getId().equals(a.getId()));
		
	}
	
	@Test
	public void getbook2(){
		Book b = new Book("bk105");
		assertNotEquals(b.getBook("bk102"),b);
	}
	
	@Test
	public void addbook1(){
		Catalog cat = ReadXMLFile();
		Book b = new Book("bk888", "123", "456", "789", 100.00, 50.00, new Date(), "012");
		cat.addBook("bk888",b);
		assertTrue((b.getBook("bk888") != null) && (b.getBook("bk888").getId().equals(b.getId())));
	}

	@Test
	public void addbook2(){
		Catalog cat = ReadXMLFile();
		Book b = new Book("bk888", "123", "456", "789", 100.00, 50.00, new Date(), "012");
		cat.addBook("bk888", b);
		assertFalse((b.getBook("bk11") != null) && (b.getBook("bk11").equals(b)));

	}
	
	
	private static Catalog ReadXMLFile() {

		Catalog cat = null;

		String basePath = new File("").getAbsolutePath();
		basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
		File file = new File(basePath);

		System.out.println(file.getAbsolutePath());
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			cat = (Catalog) jaxbUnmarshaller.unmarshal(file);
			System.out.println(cat);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return cat;

	}
}
