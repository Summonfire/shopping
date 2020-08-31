package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;

@WebServlet("/ProductDetails")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ProductDetailsServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int proCd = Integer.parseInt(request.getParameter("pro_cd"));
		System.out.println("【確認】ProductServlet（ProCd・・・）"+proCd);
		request.setAttribute("product", new ProductDao().searchById(proCd));
		request.getRequestDispatcher("/view/ProductDetails.jsp").forward(request,response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
	}
}

