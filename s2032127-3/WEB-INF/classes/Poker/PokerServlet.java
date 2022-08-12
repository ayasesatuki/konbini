package Poker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PokerServlet
 */
@WebServlet("/PokerServlet")
public class PokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PokerModel model;
    public PokerServlet() {
        super();
        // TODO Auto-generated constructor stub
        model = new PokerModel();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		model.reset();
		model.nextgame();
		request.setAttribute("model", model);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/poker.jsp");
		dispatcher.forward(request, response);

	}
	//


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(model.getButtonLabel().equals("交換")) {
			 String change[] = request.getParameterValues("change");
			 List<String> changelist = null;
			 if (change == null) {
			 changelist = new ArrayList<>();
			 } else {
			 changelist = Arrays.asList(change);
			 }
			 model.change(changelist);
		} else if (model.getChips() > 0) {
			 model.nextgame();
		} else {
			 model.reset();
			 model.nextgame();
		}
		request.setAttribute("model", model);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/poker.jsp");
		dispatcher.forward(request, response);
		
	}

}
