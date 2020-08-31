package controller;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.ProductBean;
import dao.MeisaiDao;
import dao.ProductDao;
@WebServlet("/Confirmation")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ConfirmationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Date ko_date=new Date(new java.util.Date().getTime());
		System.out.println("購入日時は"+ko_date);
		HttpSession session=request.getSession(false);
		ArrayList<ProductBean> cart=(ArrayList<ProductBean>)session.getAttribute("cart");
		for(int i=0;i<cart.size();i++) {
			System.out.println("ConfSv確認StockNmとProCd"+cart.get(i).getStock_no()+","+cart.get(i).getPro_cd());
			new ProductDao().updateProduct(cart.get(i).getPro_cd(), cart.get(i).getStock_no());
			int price=cart.get(i).getPro_price()*cart.get(i).getStock_no();
			new MeisaiDao().insertMeisai(((int)session.getAttribute("id")), cart.get(i).getPro_cd(),ko_date, price);
			System.out.println("ConfSv確認ID"+((int)session.getAttribute("id"))+"ProCd　"+cart.get(i).getPro_cd()+"Date　"+ko_date+"Price　"+price);
		}
		session.removeAttribute("cart");
		request.getRequestDispatcher("./view/Complete.jsp").forward(request, response);
	}
}
