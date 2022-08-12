package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CordTest1
 * http://localhost:8080/s2032127/CardTest1.html
 */
@WebServlet("/CordTest1")
public class CordTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CordTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<img src = \"cards/1.png\">");
			out.println("スペードA");
			out.println("<hr>");
			
			int card = (int)(Math.random() * 52) + 1;
			out.println("<img src = \"cards/"  +  card + ".png\">");
			out.println("ランダムなカード");
			out.println("<hr>");
			out.println("</html>");
			System.out.println("doGet()");
			
			
			for(int i  = 14; i < 27; i++) {
				out.println("<img src = \"cards/" + i +  ".png\" width =\" 100\" height =\" 100\">");
			}
			out.println("<hr>");
			
		}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
