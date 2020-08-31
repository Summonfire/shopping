package dao;   //Login ServletからのReqに、UserTableの情報をListに入れてRes＋Reqしている

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.UserBean;
public class UserDao{
	public UserDao() {} //サーブレットで使うインスタンスつくる（空っぽ）
	private String userCd;
	private String userPw;

	public ArrayList<UserBean>check(String userCd,String userPw){
		ArrayList<UserBean>list=new ArrayList<UserBean>();
		this.userCd=userCd;
		this.userPw=userPw;

	try {
		Class.forName("com.mysql.jdbc.Driver");//これでドライバとつながる
	}catch(ClassNotFoundException ex){
		ex.printStackTrace();
	}
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;

	try {
		String url="jdbc:mysql://localhost/ec";
		String id="root";
		String pw="password";
		conn=DriverManager.getConnection(url,id,pw);

		String sql="Select user_id,login_cd,login_pw from user where login_cd=? AND login_pw=?";
	    pst=conn.prepareStatement(sql);
	    pst.setString(1,this.userCd);  //一個目の？にuserIdをいれる
	    pst.setString(2, this.userPw);  //二個目にPwをいれる

	    rs=pst.executeQuery(); //実行

	    if(rs.next()){  //数が少なければ（定数なら）別にIFでRS.NEXTしなくてもいい
	    	int user_id=rs.getInt("user_id");  //table userからIDをgetしresultsetする処理。ここでやっとDBとつながる
	    	String login_cd=rs.getString("login_cd");
	    	String login_pw=rs.getString("login_pw");
	    	UserBean userBean=new UserBean(user_id,login_cd,login_pw);  //userbeanをインスタンス化してる
	    	list.add(userBean);  //UserArrayListにaddする。
	    }

	}catch(Exception e){
		e.printStackTrace();
		//どこでErrorなのかコンソールにErrorMsg 出すやつ。
		return list;

	} finally {
		try {
			if (pst!=null) pst.close();
			if (conn!=null) conn.close();
			if(rs!=null)rs.close();
			} catch(Exception ex) { }

}return list;

}

}
