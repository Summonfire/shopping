//（jsp）「ログアウト」ボタンを押下でユーザ情報sessionを破棄し、ログイン画面へ遷移
//(jsp)「買い物を続ける」ボタンを押下で商品検索画面へ遷移
//Jspからの値が"logout"でセッションを切ってLoginJsp、"continue"でSerchJspに遷移

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LogoutServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session=request.getSession();

		session.invalidate();
		request.setAttribute("error","ログアウトしました");
		RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
		System.out.print("log");
	    rd.forward(request, response);

	}
}
