package db;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ConvinServlet")
public class ConvinServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 public ConvinServlet() {
		 super();
	 }
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	 request.setCharacterEncoding("UTF-8");
	 String item = request.getParameter("item"); // 並び替えの項目
	 String order = request.getParameter("order"); // asc:昇順 desc:降順
	 String submit = request.getParameter("submit"); // "並び替え" "登録" "削除"
	 String newchaincode = request.getParameter("newchain");//登録するチェーンコード
	 String newkencode = request.getParameter("newkencode"); // 登録する県コード
	 String newshicode = request.getParameter("newshicode"); // 登録する市コード
	 String newmise = request.getParameter("newmise"); // 登録する店名
	 String deleteid = request.getParameter("deleteid"); // 削除するID
	 String shimei = request.getParameter("shimei"); // 市名をクリックした場合
	 String fix = request.getParameter("fix"); // code;コード,kana;五十音
	 String newId = request.getParameter("id"); //行った店コード
	 String year = request.getParameter("year"); //年
	 String month = request.getParameter("month"); //月
	 String day = request.getParameter("day"); //秒
	 String hour = request.getParameter("hour"); //時刻
	 String minute = request.getParameter("minute"); //分
	 String second = request.getParameter("second"); //時刻
	 System.out.printf("\n%s:%s:%s:\n", item, order, submit);
	 System.out.printf("%s:%s:\n", newkencode, newshicode);
	 System.out.printf("%s:%s:\n", deleteid, shimei);
	 if (submit != null) {
	 if (submit.equals("並び替え")) { // この場合は特に何もしない
		 //selectALL(item,order);
		 //selectALL(item,order,fix);
		 narabikae(item,order,fix);
	
	 } else if (submit.equals("登録")) {
	 //insert(newkencode, newshicode,newchaincode,newmise);
		 insert(newkencode, newshicode,newmise,newchaincode);
	 } else if (submit.equals("削除")) {
	 delete(deleteid);
	 } else if (submit.equals("訪問"));
	 rirekiInsert(newId,newkencode, newshicode,newmise,newchaincode,year,month,day,hour,minute,second);
	 }
	 selectAll(request, response, item, order);
	 RequestDispatcher dispatcher = request.getRequestDispatcher("/convin.jsp");
	 /*並び替えメソッド*/
	 ConvinDAO convinDAO = new ConvinDAO();
	 //boolean success = convinDAO.narabikae(item, order);
	 
	 dispatcher.forward(request, response);
	 
	 }


	private void narabikae(String item, String order, String fix) {
		ConvinDAO convinDAO = new ConvinDAO();

			 List<Convin> list  = convinDAO.narabikae(item,order,fix);
		 //System.out.println(success);
			 //request.setAttribute("list", list);
		
	
		 
		 
		 //dispatcher.forward(request, response);
	}
	
	private void selectALL(String item, String order, String fix) {
		ConvinDAO convinDAO = new ConvinDAO();
		try {
		//boolean success = convinDAO.narabikae(item,order,fix);
		 //System.out.println(success);
		 } catch (NumberFormatException e) {
		 System.out.println("不正な番号または市コードが入力されました"+e.getMessage());
		 }
		
	}
	/** サーブレットがPOSTメソッドで実行された場合でもdoGet()で処理する */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
	 doGet(request, response);
	 }
	 /** DAOを呼び出す */
	void selectAll(HttpServletRequest request, HttpServletResponse response, String item, String order)
	throws ServletException {
	 ConvinDAO ConvinDAO = new ConvinDAO();
	 List<Convin> list = ConvinDAO.findAll();
	 List<Convin> rireki = ConvinDAO.rirekiAll();
	 System.out.print(rireki);
	 request.setAttribute("list", list);
	 request.setAttribute("rireki",rireki);
	 }
	 /** DAOを呼び出す */
	 
	 void insert(String newkencode, String newshicode,String newmise ,String newchain) {
		 try {
			 //System.out.println(newnumber);
			 //System.out.println(newnumber.getClass());
			 //convinDAO convinDAO = new convinDAO();
			 //boolean success = convinDAO.insert(newnumber,newshicode);
			 //boolean success = convinDAO.insert(newnumber,newshicode);
			 //System.out.println(success);
			 //int num = Integer.parseInt(newnumber);
			 //System.out.println(num);
			 int kencode = Integer.parseInt(newkencode);
			 int code = Integer.parseInt(newshicode);
			 int chain = Integer.parseInt(newchain);
			 ConvinDAO convinDAO = new ConvinDAO();
			 //boolean success = convinDAO.insert(num,code);
			 boolean success = convinDAO.insert(kencode, code,newmise,chain);
			 System.out.println(success);
		 } catch (NumberFormatException e) {
		 System.out.println("不正な番号または市コードが入力されました"+e.getMessage());
		 }
	 }

	private void rirekiInsert(String newid ,String newkencode, String newshicode, String newmise, String newchaincode, String reyear, String remonth, String reday, String rehour, String reminute, String resecond) {
			try{
			 int id = Integer.parseInt(newid);
			 int kencode = Integer.parseInt(newkencode);
			 int shicode = Integer.parseInt(newshicode);
			 int chaincode = Integer.parseInt(newchaincode);
			 int hour = Integer.parseInt(rehour);
			 int minute = Integer.parseInt(reminute);
			 int second = Integer.parseInt(resecond);
			 int year = Integer.parseInt(reyear);
			 int month= Integer.parseInt(reminute);
			 int day = Integer.parseInt(reday);
			 ConvinDAO convinDAO = new ConvinDAO();
			 boolean success = convinDAO.rirekiInsert(id,kencode,shicode,newmise,chaincode, year, month, day, hour, minute, second);
			 System.out.println(success);
		 } catch (NumberFormatException e) {
		 System.out.println("不正な番号または市コードが入力されました"+e.getMessage());
		 }
	}
	 void insert(String newkencode, String newshicode, String newchaincode) {

		 try {
			 //System.out.println(newnumber);
			 //System.out.println(newnumber.getClass());
			 //convinDAO convinDAO = new convinDAO();
			 //boolean success = convinDAO.insert(newnumber,newshicode);
			 //boolean success = convinDAO.insert(newnumber,newshicode);
			 //System.out.println(success);
			 int kencode = Integer.parseInt(newkencode);
			 int shicode = Integer.parseInt(newshicode);
			 int chaincode = Integer.parseInt(newchaincode); 
			 ConvinDAO convinDAO = new ConvinDAO();
			 boolean success = convinDAO.insert(kencode,shicode,chaincode);
			 System.out.println(success);
		 } catch (NumberFormatException e) {
		 System.out.println("不正な番号または市コードが入力されました"+e.getMessage());
		 }
		
	}
	 
	 void selectALL(String item,String order){

		 ConvinDAO convinDAO = new ConvinDAO();
		 //boolean success = convinDAO.narabikae(item, order);
		 //System.out.println(success);
	 }
	 /*
	 public boolean insert(int number, int shicode) {
		 String url = "jdbc:h2:tcp://localhost/./s2032127";
		 Connection conn = null;
		 try {
		 conn = DriverManager.getConnection(url, "user", "pass");
		 String sql = "INSERT INTO convin(番号,市コード) VALUES(?,?)";
		 PreparedStatement pre = conn.prepareStatement(sql);
		 pre.setInt(1, number);
		 pre.setInt(2, shicode);
		 int result = pre.executeUpdate();
		 if (result == 1) return true;
		 } catch (SQLException e) {
		 e.printStackTrace();
		 } finally {
		 if (conn != null) {
		 try {
		 conn.close();
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 }
		 }
		 return false;
		 }
		} */
	 /** DAOを呼び出す */
	 void delete(String deleteid) {
		 try {
			 int id = Integer.parseInt(deleteid);
			 ConvinDAO convinDAO =new  ConvinDAO();
			 boolean success = convinDAO.delete(id);
		 } catch (NumberFormatException e) {
		 System.out.println("不正なIDが入力されました"+e.getMessage());
		 	}
	 }
}

