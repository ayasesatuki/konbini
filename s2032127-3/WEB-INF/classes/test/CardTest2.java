package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CardTest2
 */
@WebServlet("/CardTest2")
public class CardTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");
		
		String suit = request.getParameter("suit");
		String number[]  = request.getParameterValues("number");
		String color= request.getParameter("color");
		String query = request.getParameter("query");
		
		System.out.println("-----------");
		List<String>numberlist = null;
		if (number == null) {
			numberlist =  new ArrayList<>();
			}else {
				numberlist = Arrays.asList(number);
		}
		System.out.println(numberlist);
		System.out.println("color = " + color);
		System.out.println("query ="  + query);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println(suit);
		out.println("<hr>");
		out.println(color);
		out.println("<hr>");
		out.println(number);
		out.println("<hr>");
		out.println(query);
		
		
		out.println("<hr>");
		boolean suitFlag[] = new boolean[53];
		boolean numberFlag[] = new boolean[53];
		if(suit.equals("all")) {
			for(int i = 1;i<= 52 ; i++) {
				suitFlag[i] = true;
			}
		}else if( suit.equals("spade")) {
			for(int i = 1;i<= 13; i++) {
				suitFlag[i] = true;
			}
		}else if( suit.equals("heart")) {
			for(int i = 14;i<= 26; i++) {
				suitFlag[i] = true;
			}
		}
		
		out.println(numberlist.contains("1"));
		/*//webに表示する記述（アドミン的に）
		for(int i = 1;i <=13 ; i++) {
			
			//ナンバーフラグはもともと審議型で定義されているためフォー分で判定し方が望ましい
			//ハート以降の、数字的に別の値として定義されているため、その判別も畏怖分か何かで行う必要がある。
			//参考までに記述*/
			
			/*
			if ()
			numberFlag.add(numberlist.contains((str)i));
		}
		//numberFlag = [numberlist.contains("1"),numberlist.contains("2"),]
		out.println("<br>");
		*/
		//ここで画像の表示を行っている
		for(int i = 1;i <= 52; i++) {
			//選別
			//選択しとしては、回す範囲を変える方法、continueとかですーとの場合はコンティニューでもあり？
			//方法１　すーとを見て	forを回す範囲を変える。今回はradio で重複不可だから、trueである限り回すことは可能。…これはif
			//方法２　数字のほうにTrue は作れている。
			if(suitFlag[i]) {// == numberFlag[i]
				String filename = "cards/" + i + ".png";
				out.printf("<img src = \"%s\" width = \"100\" height = \"120\">", filename);
			}
		}
		
		out.println("</html>");
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
