package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BankDAO {

	String url = "jdbc:mysql://localhost:3306/bank";
	String user = "root";
	String password = "1234";
	String sql;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// 회원정보 입력
	public void insertInfo(BankDTO dto) {
		try {
			// 커넥터 연결
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("커넥터 연결");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결");

			sql = "insert into member values (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.id);
			ps.setString(2, dto.name);
			ps.setString(3, dto.age);
			ps.setString(4, dto.tel);

			// 실행 요청
			ps.executeUpdate();

			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원정보 삭제
	public void deleteInfo(String id) {
		try {
			// 커넥터 연결
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("커넥터 연결");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결");

			sql = "delete from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 실행 요청
			ps.executeUpdate();

			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원정보 수정
	public void updateInfo(BankDTO dto) {
		try {
			// 커넥터 연결
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("커넥터 연결");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결");

			sql = "update member set tel = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setString(2, dto.getId());

			// 실행 요청
			ps.executeUpdate();

			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원정보 검색
	public BankDTO selectInfo(String id) {
		BankDTO dto = new BankDTO();

		try {
			// 커넥터 연결
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("커넥터 연결");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결");

			sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 실행 요청
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setTel(rs.getString("tel"));
			}

			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 모든 회원정보 검색
	public ArrayList<BankDTO> selectInfoAll() {
		ArrayList<BankDTO> list = new ArrayList<>();

		try {
			// 커넥터 연결
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("커넥터 연결");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결");

			sql = "select * from member";
			ps = con.prepareStatement(sql);

			// 실행 요청
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				BankDTO dto = new BankDTO();
				
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
			}

			System.out.println("완료");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
