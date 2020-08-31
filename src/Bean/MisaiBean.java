package Bean;

import java.io.Serializable;

public class MisaiBean implements Serializable {

	private int mei_id;
	private int user_id;
	private int pro_cd;
	private int ko_date;
	private int mei_price;


	public int getMei_id() {
		return mei_id;
	}
	public void setMei_id(int mei_id) {
		this.mei_id = mei_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(int pro_cd) {
		this.pro_cd = pro_cd;
	}
	public int getKo_date() {
		return ko_date;
	}
	public void setKo_date(int ko_date) {
		this.ko_date = ko_date;
	}
	public int getMei_price() {
		return mei_price;
	}
	public void setMei_price(int mei_price) {
		this.mei_price = mei_price;
	}


	public MisaiBean(int mei_id,int user_id,int pro_cd,int ko_date,int mei_price) {
		setMei_id(mei_id);
		setUser_id(user_id);
		setPro_cd(pro_cd);
		setKo_date(ko_date);
		setMei_price(mei_price);
		}

}
