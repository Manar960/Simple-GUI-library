package book11;
import java.util.*;
import java.util.Comparator;
public class book  {

   private  String isbn;
   private String title;
   private String author;
   private  int edition;
   private  int publishedYear;
    boolean isBorrowed;
   
   public String getisbn() {
    	return isbn;
    }
    
    public String gettitle() {
    	return title;
    }
    
    public String getauthor() {
    	return author;
    }
    
    public int getedition() {
    	return edition;
    }
    
    public int getpublishedYear() {
    	return publishedYear;
    }
    
    public void setisbn(String isbn) {
    	this.isbn=isbn;
    }
    public void settitle(String title) {
    	this.title=title;
    }
    public void setauthor(String author) {
    	this.author=author;
    }
    
    public void setedition(int edition) {
    	this.edition=edition;
    }
    
    public void setpublishedYear(int publishedYear) {
    	this.publishedYear=publishedYear;
    }




   

    public book(String isbn, String title, String author, int edition,
                int publishedYear, boolean isBorrowed) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publishedYear = publishedYear;
        this.isBorrowed = isBorrowed;

    }

    @Override
    public String toString() {
        String isbn = String.format("%-20s", this.isbn);
        String title = String.format("%-30s", this.title);
        String author = String.format("%-24s", this.author);
        String edition = String.format("%-23s",  this.edition==1?this.edition+"st":this.edition == 2?this.edition+"end":this.edition+"th");
        String year = String.format("%-23d", this.publishedYear);
        String isBorrowed = String.format("%-14s", this.isBorrowed?"Not Available":"Available");
        return isbn  +"\t"+title   +edition +author+year+isBorrowed+"\n";
    }

    public boolean isISBNEqual(String isbn){
        return this.isbn.toLowerCase().contains(isbn.toLowerCase());
    }
    public boolean isTitleEqual(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
    public boolean isAuthorEqual(String author){
        return this.author.toLowerCase().contains(author.toLowerCase());
    }
    public boolean isYearEqual(int year){
        return this.publishedYear == year;
    }
  

	
        
        

	
}
