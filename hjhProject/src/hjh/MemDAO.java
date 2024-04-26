package hjh;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void getconn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hjh", "hjh");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 목록 기능
	List<Member> memberList() {
		List<Member> list = new ArrayList<>();
		getconn();
		String sql = "select mem_no, mem_phone, m.mem_name,trunc(b.return_date) return_date,b.rent_return, count(b.book_no) as bookc"
				+ " ,case when trunc(b.return_date) < sysdate then 'O'when trunc(b.return_date) is null then ' '"
				+ " else 'X'"
		        + " end return_status"
		        + " from rent_book b" 
		        + " right join mem m on b.men_no = m.mem_no"
		        + " group by  m.mem_no, mem_phone, m.mem_name, trunc(b.return_date), b.rent_return"
		        + "	order by m.mem_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member mm = new Member();
				mm.setMemNo(rs.getInt("mem_no"));
				mm.setName(rs.getString("mem_name"));
				mm.setNumber(rs.getString("mem_phone"));
				mm.setBookcount(rs.getInt("bookc"));
				mm.setReturnStatus(rs.getString("return_status"));
		
				list.add(mm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 회원 등록 기능
	boolean InsertMem(Member member) {
		getconn();
		String sql = " insert into mem(mem_no, mem_name,mem_phone)"//
				+ "values(mem_seq.nextval,?,?)";//
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getNumber());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;	
			} 
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	
	//회원 정보 수정 기능
	boolean updateMember(Member member) {
		getconn();
		String sql = "update mem";
		 sql += " set mem_name = ?";
		 sql += ", mem_phone = ?";
		 sql += "where mem_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getNumber());
			psmt.setInt(3, member.getMemNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) { 
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return false;		
	}
	
	//회원 삭제 기능
	boolean deleteMember(Member member) {
		getconn();
		String sql = "delete mem where mem_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, member.getMemNo());
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
// end of class
