package hjh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReturnDAO {
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
	
	
	// 대출도서 목록 기능
	List<RentBook> returnlist() {
		List<RentBook> list = new ArrayList<>();
		getconn();
		String sql = "select b.book_no, bk.book_title, author,  decode(rent_return, 'Y', '대출', '반납')  as flag, m.mem_name, rent_date,return_date\r\n"
				+ "from rent_book b\r\n" + "join mem m\r\n" + "on b.men_no = m.mem_no\r\n" + "join book bk\r\n"
				+ "on b.book_no = bk.book_no\r\n" + "order by b.book_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				RentBook bk = new RentBook();
				bk.setBookNo(rs.getInt("book_no"));
				bk.setBookTitle(rs.getString("book_title"));
				bk.setAuthor(rs.getString("author"));
				bk.setRentreturn(rs.getString("flag"));
				bk.setName(rs.getString("mem_name"));
				bk.setRentdate(rs.getString("rent_date"));
				bk.setReturndate(rs.getString("return_date"));

				list.add(bk);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//대출하기
	public boolean rentBook(RentBook rentbook) {
		getconn();
		String sql = " insert into rent_book"
				+ " values (rent_seq.nextval,?,?,sysdate,sysdate+14,'Y')";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rentbook.getMemNo());
			psmt.setInt(2, rentbook.getBookNo());
			
			int r = psmt.executeUpdate();
			
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
	//반납하기
	public boolean returnBook(RentBook rentbook) {
		getconn();
		String sql = " update rent_book"
				+ " set rent_return  = 'N'"
				+ " where men_no = ?"
				+ " and book_no = ?"
				+ " and rent_return = 'Y' ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rentbook.getMemNo());
			psmt.setInt(2, rentbook.getBookNo());
			
			int r = psmt.executeUpdate();
			
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
	public List<Member> changeName(String name) {
		getconn();
		String sql = "select mem_no from mem where mem_name = ?";
		List<Member> list = new ArrayList<>();
		
		Member member = new Member();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				member.setMemNo(rs.getInt("mem_no"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
	
	
}//end of class
