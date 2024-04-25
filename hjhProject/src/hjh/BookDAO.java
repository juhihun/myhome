package hjh;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookDAO {

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

	// 도서 목록 기능
	List<Book> bookList(SearchVO search) {
		getconn();

		List<Book> list = new ArrayList<>();
		String sql = "select * \r\n" //
				+ "from book\r\n"//
				+ "where 1=1\r\n"//
				+ "and book_no = nvl(?, book_no)\r\n"//
				+ "and book_title like '%'||?||'%'\r\n"//
				+ "and author like '%'||?||'%'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search.getBookNo());
			psmt.setString(2, search.getTitle());
			psmt.setString(3, search.getAuthor());

			rs = psmt.executeQuery();

			while (rs.next()) {
				Book bk = new Book();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
	
	// 도서 등록 기능
	
	boolean insertBook(UpdateVO update) {
		getconn();
		String sql = "insert into book(book_no, book_title,author,buy_date,price)"//
				+ "values(book_seq.nextval,?,?,?,?)";//
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, update.getTitle());
			psmt.setString(2, update.getAuthor());
			psmt.setString(3, update.getBuyDate());
			psmt.setString(4, update.getPrice());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	// 도서 수정 기능
	boolean updateBook(UpdateVO update) {
		getconn();
		String sql = "update book";
		sql += " set book_title = ? ";
		sql += " , author = ? ";
		sql += " , buy_date = ? ";
		sql += " ,  price = ? ";
		sql += " where book_no =  ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, update.getTitle());
			psmt.setString(2, update.getAuthor());
			psmt.setString(3, update.getBuyDate());
			psmt.setString(4, update.getPrice());
			psmt.setInt(5, update.getBookNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//도서 삭제 기능
	boolean deleteBook(UpdateVO update) {
		getconn();
		String sql = "delete book where book_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, update.getBookNo());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}// end of class
