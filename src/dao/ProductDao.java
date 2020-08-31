package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.ProductBean;
public class ProductDao {
	Connection conn=null;
	ResultSet rs=null;
	PreparedStatement pst=null;
	String url="jdbc:mysql://localhost/ec";
    String id="root";
	String pw="password";
	public ProductDao() {}

	 //CatとKeyの検索
	public ArrayList<ProductBean>search (int cat,String key){
		ArrayList<ProductBean>prolist=new ArrayList<ProductBean>();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException ex){
		ex.printStackTrace();
	}
	try {
	conn=DriverManager.getConnection(url,id,pw);
	    String  sql= "select * from product where pro_name like ? and cat_id = ? ";
		pst = conn.prepareStatement(sql);
		pst.setString(1,"%"+key+"%");
		pst.setInt(2,cat);
		rs = pst.executeQuery();
	while(rs.next()){
	    	ProductBean productBean=new ProductBean();
	    	productBean.setPro_cd(rs.getInt("pro_cd"));
	    	productBean.setPro_name(rs.getString("pro_name"));
	    	productBean.setStock_no(rs.getInt("stock_no"));
	    	productBean.setPro_price(rs.getInt("pro_price"));
	    	productBean.setCat_id(rs.getInt("cat_id"));
	    	productBean.setPro_img(rs.getString("pro_img"));
	    	productBean.setPro_msg(rs.getString("pro_msg"));
	    	prolist.add(productBean);
	    	System.out.println("PD確認用"+key);
	    }
	try {
		if (pst!=null) pst.close();
		if (conn!=null) conn.close();
		return prolist;
		} catch(Exception ex) { }

	}catch(Exception e){
		e.printStackTrace();
	}
	return prolist;
}
	//Idでの検索→ProDtailJspに表示
	public ProductBean searchById(int proCd) {
		try {
			try {
				conn=DriverManager.getConnection(url,id,pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}

	 String  sql2= "select * from product where pro_cd = ? ";
	 ProductBean productBean=new ProductBean();
	 try {
		 pst = conn.prepareStatement(sql2);
			pst.setInt(1,proCd);
			rs = pst.executeQuery();
		 while(rs.next()){
		    	productBean.setPro_cd(rs.getInt("pro_cd"));
		    	productBean.setPro_name(rs.getString("pro_name"));
		    	productBean.setStock_no(rs.getInt("stock_no"));
		    	productBean.setPro_price(rs.getInt("pro_price"));
		    	productBean.setCat_id(rs.getInt("cat_id"));

		    	productBean.setPro_img(rs.getString("pro_img"));
		    	productBean.setPro_msg(rs.getString("pro_msg"));
		 }
		 try {
		    		if (pst!=null) pst.close();
		    		if (conn!=null) conn.close();
		    	}catch(Exception e){
			e.printStackTrace();
	 }
	 } catch (SQLException e1) {
		e1.printStackTrace();
	}finally {
	 }
	return productBean;
}
	//Completeと同時に購入数だけ在庫を減らす
	public void updateProduct(int ProCd,int num){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pw);
			String sql="update product set stock_no = stock_no - "+num+" where pro_cd = ?;";
			PreparedStatement ps=conn.prepareStatement(sql);
			System.out.println(sql+","+ProCd+","+num);
			ps.setInt(1, ProCd);
			ps.executeUpdate();
			if(ps!=null) {
				ps.close();
			}if(conn!=null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst!=null) pst.close();
				if (conn!=null) conn.close();
				if(rs!=null)rs.close();
				} catch(Exception ex) { }

}}}
