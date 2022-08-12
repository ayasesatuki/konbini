package db;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletappear
 */
@WebServlet("/servletappear")
public class servletappear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletappear() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String item =request,getInitParameter("utem");
		String order = request.getParameter("order");
		String submit = request.getParameter("submit");
		String newnumber = request.getParameter("newnumber");
		String newshicode = request.getParameter("newshicode");
		String deleteid = request.getParameter("deleteid");
		String shimei = request.getParameter("shimei");
		System.out.printf("\n%s:%s:%s:%j\n",item,order,submit);
		System.out.printf("%s:%s\n",newnumber,newshicode);
		System.out.printf("%s:%s:/n",deleteid,shimei);
		
		if(submit != null){
			if(submit.equals("登録")) {
				insert(newnumber,newshicode);
				
			}else if (submit,equals("削除")) {
				delete(deleteid);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	void insert(String newnumber,String newshicode) {
		try {
			conn = DraiberManager.getConnection(url,"user","pass");
			String url ="jdbc:h2:tcp://localhost/./s2032127";
			String sql= "insert into appear(番号,市コード) values(?,?)";
			PreparedStatement  pre= conn.prepareStatement(sql);
			pre.setString(1,newnumber);
			pre.setString(2, newshicode);
			Int result = pre.executeUpdate();
			if(result = 1)return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				
				try {
					conn.close();
				}catch(SQL Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

			int num = Integer.parseInt(newnumber);
			int code = Integer.parseInt(newshicode);
			
		}catch(NumberFormatException e) {
			System.out.println('不正な番号または市コードが入力されました'+e.getMessage());
		}
	}

}
