package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserBean;
import dao.UserDao;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/view/Login.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cd=request.getParameter("cd");
		String pass=request.getParameter("pass"); //←jspからPostしてきた値
		System.out.println("【確認】LoginServlet（LoginCdとPass・・・）"+cd+"  "+pass);
		UserDao ud = new UserDao();
		ArrayList<UserBean> list = ud.check(cd,pass);
		list=ud.check(request.getParameter("cd"),request.getParameter("pass"));
		System.out.println("ここまで");
		if(list.size()==1) { //LoginSuccess
			//SEARCHのページにForwardする。という内容をResponseする。
			HttpSession session = request.getSession(true);
			session.setAttribute("id",list.get(0).getUser_id());
			response.sendRedirect("./Search");
		}else   if(cd.equals("") && pass.equals("")){
		    request.setAttribute("error","名前とパスワードが入力されていません");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");
		    dispatcher.forward(request, response);
		}else   if(cd.equals("")){
		    request.setAttribute("error","名前が入力されていません");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");
		    dispatcher.forward(request, response);
		}else if(pass.equals("")){
			request.setAttribute("error", "パスワードが入力されていません");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Login.jsp");
		    dispatcher.forward(request, response);
		}else{
			request.setAttribute("error", "入力内容を確認して下さい");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/view/Login.jsp");
			dispatcher.forward(request,response);
	}
	}
}