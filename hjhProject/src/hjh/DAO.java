package hjh;

import java.sql.*;
import java.util.*;

public class DAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getconn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, "hjh", "hjh");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	//도서목록기능
	List<Book> bookList(){
		getconn();
		List<Book> list = new ArrayList<>();
		String sql = "select * from book";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("author"));
				bk.setBuydate(rs.getString("buy_date"));
				bk.setPrice(rs.getString("price"));
		
				list.add(bk);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//도서검색기능
	
	//도서등록기능
	boolean insertBook(Book book) {
		getconn();
		String sql = "insert into book(book_no, book_title,author,buy_date,price)"
				+"values(book_seq.nextval,?,?,?,?)";
	
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,book.getTitle());
				psmt.setString(2, book.getAuthor());
				psmt.setString(3, book.getBuydate());
				psmt.setString(4, book.getPrice());
				
				int r = psmt.executeUpdate();
				if(r>0) {
					return true;
				}			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		return false;
	}	
	//도서 수정 기능
	boolean updateBook(Book book) {
		getconn();
		String sql = "update book";
		sql +=" set book_title = ? ";
		sql +=" , author = ? ";
		sql +=" , buy_date = ? ";
		sql +=" ,  price = ? ";
		sql +=" where book_no =  ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getBuydate());
			psmt.setString(4, book.getPrice());
			psmt.setInt(5, book.getBookNo());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
