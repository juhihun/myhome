package hjh;

import java.sql.*;
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

	Scanner sc = new Scanner(System.in);

	// 도서목록기능
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

	// 도서등록기능
	boolean insertBook(Book book) {
		getconn();
		String sql = "insert into book(book_no, book_title,author,buy_date,price)"//
					+ "values(book_seq.nextval,?,?,?,?)";//

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getBuydate());
			psmt.setString(4, book.getPrice());

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
	boolean updateBook(Book book) {
		getconn();
		String sql = "update book";
		sql += " set book_title = ? ";
		sql += " , author = ? ";
		sql += " , buy_date = ? ";
		sql += " ,  price = ? ";
		sql += " where book_no =  ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2, book.getAuthor());
			psmt.setString(3, book.getBuydate());
			psmt.setString(4, book.getPrice());
			psmt.setInt(5, book.getBookNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	boolean deleteBook(int book) {
		getconn();
		String sql = "delete book where book_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, book);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 회원목록
	List<Member> memberList() {
		getconn();
		List<Member> list = new ArrayList<>();
		String sql = "select * from mem";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member mm = new Member();
				mm.setMemNo(rs.getInt("mem_no"));
				mm.setName(rs.getString("mem_name"));
				mm.setNumber(rs.getString("mem_phone"));
				mm.setBookNo(rs.getInt("book_no"));

				list.add(mm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
