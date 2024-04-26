package hjh;

public class Member {

	private int memNo;
	private String name;
	private String number;
	private int bookNo;
	private int bookcount; 
	private String returnStatus;
	
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public int getBookcount() {
		return bookcount;
	}
	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	@Override

	public String toString() {
		return String.format("\t%3d\t%6s\t\t%10s\t  %2d\t %2s",memNo,name,number,bookcount,returnStatus);
	}
	

}
