package hjh;

public class SearchVO {
	private String title;
	private String author;
	private String bookNo;

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

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "SearchVO [title=" + title + ", author=" + author + ", bookNo=" + bookNo + "]";
	}

}
