package hjh;

public class UpdateVO {

		private String title;
		private String author;
		private String bookNo;
		private String price;
		private String buyDate;
		

		public String getBuyDate() {
			return buyDate;
		}

		public void setBuyDate(String buyDate) {
			this.buyDate = buyDate;
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

		public String getBookNo() {
			return bookNo;
		}

		public void setBookNo(String bookNo) {
			this.bookNo = bookNo;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "UpdateVO [title=" + title + ", author=" + author + ", bookNo=" + bookNo + ", price=" + price
					+ ", buyDate=" + buyDate + "]";
		}

	
	}

