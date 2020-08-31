/* searchservlet */
package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.CategoryBean;
import Bean.ProductBean;
import dao.CategoryDao;
import dao.ProductDao;

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession(false).setAttribute("catList", new CategoryDao().catAll());
		request.setAttribute("proList", new ArrayList<ProductBean>());
		request.getRequestDispatcher("./view/Search.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Integer, CategoryBean> catList=(HashMap<Integer,CategoryBean>)request.getSession().getAttribute("catList");
		ArrayList<ProductBean> proList=new ArrayList<ProductBean>();
		if(request.getParameter("category").contentEquals("")) {
			for(int i:catList.keySet()) {//CatIdをSet
				proList.addAll(new ProductDao().search(i,request.getParameter("product_name")));
			}
		}else {
			proList=new ProductDao().search(Integer.parseInt(request.getParameter("category")),request.getParameter("product_name"));
		}
		if(proList.size()==0)request.setAttribute("error","<p>検索結果がありません</p>");
		        request.setAttribute("proList", proList);
		        request.getRequestDispatcher("./view/Search.jsp").forward(request, response);
		 }
	}