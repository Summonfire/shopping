
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		String[] LuckArray= {"吉","大吉","普通","A","C","R"};
		int index=(int)(Math.random()*6);
		String luck=LuckArray[index];

		String[] PersonArray= {"","","","","",""};
		int index2=(int)(Math.random()*6);
		String person=PersonArray[index2];

		Date date = new Date(); //util inport
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
		String today = sdf.format(date);


	    response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out=response.getWriter();
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>占い</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<P>"+today+"  "+person+"の運勢は"+luck+"です</p>");
	    out.println("</body>");
	    out.println("</html>");

	}

}
