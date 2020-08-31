package Bean;

import java.io.Serializable;

public class CategoryBean implements Serializable {

	private int cat_id;
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	private String cat_name;

	public CategoryBean(String cat_name,int cat_id) {

		setCat_name(cat_name);
		setCat_id(cat_id);

	}


}
