package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MeisaiDao {
	final String DB_PATH;
	final String DB_USER;
	final String DB_PASSWORD;
	public MeisaiDao() {
		DB_PATH="jdbc:mysql://localhost/ec";
		DB_USER="root";
		DB_PASSWORD="password";
	}
	public void insertMeisai(int userId,int proCd,Date ko_date,int price){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD);
			String sql = "insert into meisai (user_id,pro_cd,ko_date,mei_price) values (?,?,?,?);";
			System.out.println("MeisaiDao確認SQL　"+sql);
			PreparedStatement ps=conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, proCd);
			ps.setDate(3,new java.sql.Date(ko_date.getTime()));
			ps.setInt(4, price);
			ps.executeUpdate();
			if(ps!=null) {
				ps.close();
			}if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {}
	}
}
