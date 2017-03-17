
package pkgLibrary;

import java.io.File;
import java.util.Date;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.Marshaller;

public class Book {

	private String id;
	private String author;
	private String title;
	private String genre;
	private double price;
	private double Cost;
	private Date publish_date;
	private String description;

	public Book() {

	}
	public Book(String id) {
		Book c = getBook(id);
		this.id = c.getId();
		this.author = c.getAuthor();
		this.title = c.getTitle();
		this.genre = c.getGenre();		
		this.price = c.getPrice();
		this.Cost = c.getCost();
		this.publish_date = c.getPublish_date();
		this.description = c.getDescription();
	}
	
	public Book(String id, String author, String title, String genre, double price, double Cost, Date publish_date, String description)
	{
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;		
		this.price = price;
		this.Cost = Cost;
		this.publish_date = publish_date;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}

	@XmlAttribute
	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getCost() {
		return Cost;
	}

	@XmlElement
	public void setCost(double Cost) {
		this.Cost = Cost;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	@XmlElement
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public Book getBook(String id) {
		try
		{
			Catalog cat = ReadXMLFile();
		for(Book b : cat.getBooks()){
			if(b.getId().equals(id))
				return b;
		}
		throw new BookException(this);
	}catch (BookException exc){
		System.out.println("can not find it");
		return null;
	}
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
	private static void WriteXMLFile(Catalog cat) {
		try {

			String basePath = new File("").getAbsolutePath();
			basePath = basePath + "\\src\\main\\resources\\XMLFiles\\Books.xml";
			File file = new File(basePath);

			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cat, file);
			jaxbMarshaller.marshal(cat, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	private static Catalog ReadCatalog() {
		Catalog cat = ReadXMLFile();
		
		System.out.println("cat ID " + cat.getId());
		System.out.println("Book count: " + cat.getBooks().size());

		return cat;		
	}
	
}
