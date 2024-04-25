package hjh;

public class Book {

	private int bookNo;
	private String title;
	private String author;
	private String buydate;
	private String price;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBuydate() {
		return buydate;
	}
	public void setBuydate(String buydate) {
		this.buydate = buydate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
//	public String toString() {
//		return  bookNo + "\t" + title + "\t" + author + "\t" + buydate
//				+ "\t" + price;
//	}
	public String toString() {
		return String.format("\t%3d\t  %10s\t  %10s\t%20s\t%20s",bookNo,title,author,buydate,price);
	}
	

	
	
	
	
}
