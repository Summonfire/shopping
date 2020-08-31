package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class TestDao {
	final String DB_PATH;
	final String DB_USER;
	final String DB_PASSWORD;
	public TestDao() {
		DB_PATH="jdbc:mysql://localhost/ec";
		DB_USER="root";
		DB_PASSWORD="password";
	}
	public void insertMeisai(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_PATH, DB_USER, DB_PASSWORD);
			String sql = "create table test (id int,name varchar(10),int price)";
			String sql2 = "insert into test (id,name,price) values (1,test,100)";
			System.out.println("MeisaiDao確認SQL　"+sql);
			System.out.println("MeisaiDao確認SQL　"+sql2);
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps = conn.prepareStatement(sql);
			ps=conn.prepareStatement(sql2);
						ps.executeQuery();
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
