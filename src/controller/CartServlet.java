package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ProductBean;
import dao.ProductDao;

@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CartServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("number"));
		//ProDtailsJspからNumberで個数をGetしてくる
		System.out.println("【確認】CartSv・・・"+num+"個");
		HttpSession session=request.getSession(false);
		ArrayList<ProductBean> cart=(ArrayList<ProductBean>)session.getAttribute("cart");
		if(cart==null) {
			cart=new ArrayList<ProductBean>();
		}
		if(num!=0) {
			 ProductBean pro=new ProductDao().searchById(Integer.parseInt(request.getParameter("proCd")));
				pro.setStock_no(num);
				cart.add(pro);
		}
		if(cart.size()==0) {
			request.setAttribute("error","カートに商品が入っていません");
		}else{
		}
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("./view/Cart.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/view/Confirmation.jsp").forward(request,response);
	}
}
