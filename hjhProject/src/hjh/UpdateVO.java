package hjh;

public class UpdateVO {

		private String title;
		private String author;
		private int bookNo;
		private String price;
		private String buyDate;
		


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

		public int getBookNo() {
			return bookNo;
		}

		public void setBookNo(int bookNo) {
			this.bookNo = bookNo;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
		public String getBuyDate() {
			return buyDate;
		}
		
		public void setBuyDate(String buyDate) {
			this.buyDate = buyDate;
		}

		@Override
		public String toString() {
			return "UpdateVO [title=" + title + ", author=" + author + ", bookNo=" + bookNo + ", price=" + price
					+ ", buyDate=" + buyDate + "]";
		}

	
	}

