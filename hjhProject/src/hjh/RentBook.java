package hjh;

public class RentBook {

	private int bookNo;
	private String bookTitle;
	private String author;
	private String rentreturn;
	private String rentdate;
	private String returndate;
	private int memNo;
	private int rentNo;
	private String name;
	
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRentdate() {
		return rentdate;
	}
	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}
	public String getRentreturn() {
		return rentreturn;
	}
	public void setRentreturn(String rentreturn) {
		this.rentreturn = rentreturn;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public int getRentNo() {
		return rentNo;
	}
	public void setRentNo(int rentNo) {
		this.rentNo = rentNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("\t%3d\t  %10s\t  %10s\t%6s\t%10s\t%20s\t%20s",bookNo,bookTitle,author,rentreturn,name,rentdate,returndate);
	}
	
	
	
}
