package dao; //Category Tableから

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import Bean.CategoryBean;

public class CategoryDao {
	public CategoryDao() {}
	public HashMap<Integer,CategoryBean>catAll(){
		HashMap<Integer,CategoryBean>CategoryBeanMap=new HashMap<Integer,CategoryBean>();
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
		String sql="Select * from category";
	    pst=conn.prepareStatement(sql);
	    rs=pst.executeQuery();
	    while(rs.next()){
	    	String cat_name=rs.getString("cat_name");
	    	int cat_id=rs.getInt("cat_id");
	    	CategoryBean categoryBean=new CategoryBean(cat_name,cat_id);
	    	CategoryBeanMap.put(cat_id,categoryBean);
	    }
	    try {
			if (pst!=null) pst.close();
			if (conn!=null) conn.close();
			} catch(Exception ex) { }
		return CategoryBeanMap;
	}catch(Exception e){
		e.printStackTrace();
		return CategoryBeanMap;
	} finally {
		try {
			if (pst!=null) pst.close();
			if (conn!=null) conn.close();
			if(rs!=null)rs.close();
			} catch(Exception ex) { }
}
}
}