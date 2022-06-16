package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Member;

public class MemberDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private ResultSet rs;
	private String sql;

	public int requestcustno() {
		int cnt = 0;
		con = DBConn.getConnection();
		sql = "SELECT NVL(MAX(custno),0)+1 as t1 FROM member_tbl_02";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				cnt = rs.getInt("t1");
			}
			System.out.println("cnt : " + cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;

	}

	public int insert(Member member) {
		int cnt = 0;
		con = DBConn.getConnection();
		sql = "insert into member_tbl_02 (custno, custname, phone, address, join, grade, city) \r\n"
				+ "values (?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, member.getCustno());
			pstmt.setString(2, member.getCustname());
			pstmt.setString(3, member.getCustphone());
			pstmt.setString(4, member.getCustaddress());
			pstmt.setString(5, member.getCustjoindate());
			pstmt.setString(6, member.getCustgrade());
			pstmt.setString(7, member.getCustcity());
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public List<Member> selectAll(Member member) {
		List<Member> mList = new ArrayList<>();
		con = DBConn.getConnection();
		sql = "select * from member_tbl_02";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setCustno(rs.getInt("custno"));
				member.setCustname(rs.getString("custname"));
				member.setCustphone(rs.getString("phone"));
				member.setCustaddress(rs.getString("address"));
				member.setCustjoindate(rs.getString("join"));
				member.setCustgrade(rs.getString("grade"));
				member.setCustcity(rs.getString("city"));
				mList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}
	
	public Member selectOne(int custno) {
		Member member = null;
		con = DBConn.getConnection();
		sql = "select * from member_tbl_02 where custno = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, custno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member();
				member.setCustno(custno);
				member.setCustname(rs.getString("custname"));
				member.setCustphone(rs.getString("phone"));
				member.setCustaddress(rs.getString("address"));
				member.setCustjoindate(rs.getDate("join").toString());
				member.setCustgrade(rs.getString("grade"));
				member.setCustcity(rs.getString("city"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return member;
		
	}
	
	public int updateUser(int custno) {
		int cnt = 0;
		Member member = new Member();
		con = DBConn.getConnection();
		sql = "update member_tbl_02\r\n"
				+ "  set custname = ?,\r\n"
				+ "      phone=?,\r\n"
				+ "      address=?,\r\n"
				+ "      join=?,\r\n"
				+ "      grade=?,\r\n"
				+ "      city=?\r\n"
				+ " where custno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getCustname());
			pstmt.setString(2, member.getCustphone());
			pstmt.setString(3, member.getCustaddress());
			pstmt.setString(4, member.getCustjoindate());
			pstmt.setString(5, member.getCustgrade());
			pstmt.setString(6, member.getCustcity());
			pstmt.setInt(7, custno);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public List<Map<String, Object>> result(){
		List<Map<String, Object>> mList = new ArrayList<Map<String,Object>>();
		con = DBConn.getConnection();
		sql = "select mn.custno, mb.custname, \r\n"
				+ "    decode(mb.grade,'A','VIP','B', '일반', 'C', '직원') grade,\r\n"
				+ "    sum(mn.price) price\r\n"
				+ "from money_tbl_02 mn join member_tbl_02 mb on(mn.custno = mb.custno)\r\n"
				+ "group by mn.custno, mb.custname, mb.grade\r\n"
				+ "order by price desc"; 
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String, Object>(); 
				map.put( "custno",rs.getInt("custno"));
				map.put("custname", rs.getString("custname"));
				map.put("custgrade", rs.getString("grade"));
				map.put("sales", rs.getInt("price"));
				
				mList.add(map);

			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mList;
	}
}
 