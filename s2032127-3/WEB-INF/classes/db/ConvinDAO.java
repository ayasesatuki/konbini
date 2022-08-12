package db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
/** テーブルSTORE用のDAO */
public class ConvinDAO {
/** プログラム起動時に一度だけ実行される */
static {
try {
Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
} catch (Exception e) {
e.printStackTrace();
}
}
/** 1件のデータを追加する．成功ならtrueを返す． */
public boolean insert(int number, int shicode) {
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "INSERT INTO store(番号,市コード) VALUES(?,?)";
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

/** 1件のデータを追加する．成功ならtrueを返す． */
public boolean insert(int kencode, int shicode,int chaincode) {
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "INSERT INTO store(県コード,市コード,チェーン名) VALUES(?,?,?)";
PreparedStatement pre = conn.prepareStatement(sql);
pre.setInt(1, kencode);
pre.setInt(2, shicode);
pre.setInt(3,chaincode);
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


public List<Convin> findAll() {
List<Convin> list = new ArrayList<>();
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "select STORE.ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 ";
//String sql = "select store.id ,store.チェーン名,ken.県名 ,shi.市名 , 店名,日付,時刻 from ken,shi,store,rireki where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 and store.id = rireki.id";
PreparedStatement pre = conn.prepareStatement(sql);
ResultSet rs = pre.executeQuery();
while (rs.next()) {
	 int id = rs.getInt("ID");
	 //int number = rs.getInt("番号");
	 //String name = rs.getString("名前");
	 String ken = rs.getString("県名");
	 String shi = rs.getString("市名");
	 String mise = rs.getString("店名");
	 //Date date = rs.getDate("日付");
	 //Time time = rs.getTime("時刻");
	 String chain = rs.getString("チェーン名");
	 //Convin  p = new Convin(id , ken ,shi,chain);
	 Convin  p = new Convin(id , ken ,shi,chain,mise);
//Convin p = new Convin(id  , ken , shi , date ,time ,chain);
list.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
} finally {
if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
return null;
}
}
}
return list;
}
//public 

public List<Convin> narabikae(String item,String order , String code) {
List<Convin> list = new ArrayList<>();
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "";
	if(item != null) {
	if(code.equals("kana")) {
		if(item.equals("市名")) {
			if(order.equals("desc")) {
				sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by 市名 desc" ;
			}else {
				sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by 市名 asc" ;
			}
		}
		else if(item.equals("県名")) {
			if(order.equals("desc")) {
				sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by 県名 desc" ;
			}else {
				sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by 市名 asc" ;
			}
		}
		
	}else {
		if (item.equals("市名")) {
			sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by store.市 desc" ;
		}else if(item.endsWith("県名")) {
			sql = "select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 order by store.県 desc" ;
		}
	}
}
System.out.println(sql);
//String sql = "select store.id ,store.チェーン名,ken.県名 ,shi.市名 , 店名,日付,時刻 from ken,shi,store,rireki where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 and store.id = rireki.id";
PreparedStatement pre = conn.prepareStatement(sql);
ResultSet rs = pre.executeQuery();
while (rs.next()) {
	 int id = rs.getInt("ID");
	 //int number = rs.getInt("番号");
	 //String name = rs.getString("名前");
	 String ken = rs.getString("県名");
	 String shi = rs.getString("市名");
	 String mise = rs.getString("店名");
	 //Date date = rs.getDate("日付");
	 //Time time = rs.getTime("時刻");
	 String chain = rs.getString("チェーン名");
	 //Convin  p = new Convin(id , ken ,shi,chain);
	 Convin  p = new Convin(id , ken ,shi,chain,mise);
//Convin p = new Convin(id  , ken , shi , date ,time ,chain);
list.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
} finally {
if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
return null;
}
}
}
return list;
}

/** 1件のデータを日時を指定して追加する．成功ならtrueを返す． */
public boolean rirekiInsert(int ID,int kencode, int shicode,
int year, int month, int day, int hour, int minute, int second) {
		String url = "jdbc:h2:tcp://localhost/./s2032127";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "INSERT INTO rireki(番号,県コード,市コード,日付,時刻) VALUES(?,?,?,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			String datestr = String.format("%4d-%02d-%02d", year, month, day);
			Date date = Date.valueOf(datestr);
			String timestr = String.format("%02d:%02d:%02d", hour, minute, second);
			Time time = Time.valueOf(timestr);
			pre.setInt(1, ID);
			pre.setInt(2, kencode);
			pre.setInt(3,shicode);
			pre.setDate(4, date);
			pre.setTime(5, time);;
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


public boolean delete(int id) {
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
	conn = DriverManager.getConnection(url, "user", "pass");
	//String sql = "delete from store where id = store(id) VALUES(?)";
	String sql = "DELETE FROM store WHERE ID=?";
	
	PreparedStatement pre = conn.prepareStatement(sql);
	pre.setInt(1, id);
	//pre.setInt(2, shicode);
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
/*
public boolean narabikae(String item,String order) {
	System.out.println(item);
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(url, "user", "pass");
		//String sql = "delete from store where id = store(id) VALUES(?)";
		String sql = "";
		if( order.equals("desc")) {
			sql = "SELECT * from store order by " + item +" desc";
		}else {
			sql = "SELECT * from store order by " + item ;
		}
		System.out.println(sql);
		PreparedStatement pre = conn.prepareStatement(sql);
		//pre.setString(1, item);
		//pre.setString(2, order);
		if (order == "desc") {
			
		}
		System.out.println(pre);
		//int result = pre.executeUpdate();
		boolean result = pre.execute();
		if ( result)return true;
		//if (result == 1) return true;
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
		
	
}*/
/*
public boolean insert(int kencode, int code, String newmise, int chain) { {
		String url = "jdbc:h2:tcp://localhost/./s2032127";
		Connection conn = null;
		try {
		conn = DriverManager.getConnection(url, "user", "pass");
		String sql = "INSERT INTO store(県,市,チェーン名,店名) VALUES(?,?,?,\'" + newmise+ "\' )";
		//String sql = "INSERT INTO store(県,市,チェーン名) VALUES(?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, kencode);
		pre.setInt(2, code);
		pre.setInt(3,chain);
		//pre.setString(4, newmise);
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
	//return false;
}*/
public boolean insert(int kencode, int code, String newmise, int chain) { {
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
	conn = DriverManager.getConnection(url, "user", "pass");
	//String sql = "INSERT INTO store(県,市,チェーン名,店名) VALUES(?,?,?,?)";
	String sql = "INSERT INTO store(県,市,チェーン名,店名) VALUES(?,?,?,\'"+ newmise+"\')";
	//String sql = "INSERT INTO store(県,市,チェーン名) VALUES(?,?,?)";
	//System.out.println(sql);
	PreparedStatement pre = conn.prepareStatement(sql);
	pre.setInt(1, kencode);
	pre.setInt(2, code);
	pre.setInt(3,chain);
	//pre.setString(4, newmise);
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
//return false;
}
/*
public boolean narabikae(String item, String order, String fix) {
	System.out.println(item);
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(url, "user", "pass");
		//String sql = "delete from store where id = store(id) VALUES(?)";
		String sql = "";
		if( order.equals("desc")) {
			sql ="select STORE .ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 　order by store.市 desc";
		}else {
			sql = "SELECT * from store order by " + item ;
		}
		System.out.println(sql);
		PreparedStatement pre = conn.prepareStatement(sql);
		//pre.setString(1, item);
		//pre.setString(2, order);
		if (order == "desc") {
			
		}
		System.out.println(pre);
		//int result = pre.executeUpdate();
		boolean result = pre.execute();
		if ( result)return true;
		//if (result == 1) return true;
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
		
}*/

public List<Convin> rirekiAll() {
List<Convin> rireki = new ArrayList<>();
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
//String sql = "select STORE.ID,チェーン名,ken.県名 ,shi.市名 , 店名 from ken,STORE  , shi  where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 ";
String sql = "select store.id ,store.チェーン名,ken.県名 ,shi.市名 , 店名,日付,時刻 from ken,shi,store,rireki where ken.県コード  = STORE .県 and SHI .市コード = STORE  .市 and store.id = rireki.id";
System.out.print(sql);
PreparedStatement pre = conn.prepareStatement(sql);
ResultSet rs = pre.executeQuery();
while (rs.next()) {
	 int id = rs.getInt("ID");
	 //int number = rs.getInt("番号");
	 //String name = rs.getString("名前");
	 String ken = rs.getString("県名");
	 String shi = rs.getString("市名");
	 String mise = rs.getString("店名");
	 Date date = rs.getDate("日付");
	 Time time = rs.getTime("時刻");
	 String chain = rs.getString("チェーン名");
	 //Convin  p = new Convin(id , ken ,shi,chain);
	 Convin  p = new Convin(id , ken ,shi,chain,mise,date,time);
//Convin p = new Convin(id  , ken , shi , date ,time ,chain);
rireki.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
} finally {
if (conn != null) {
try {
conn.close();
} catch (SQLException e) {
e.printStackTrace();
return null;
}
}
}
return rireki;
}

/** 1件のデータを日時を指定して追加する．成功ならtrueを返す． */
public boolean rirekiInsert(int ID,int kencode, int shicode,String mise,int Chain,
int year, int month, int day, int hour, int minute, int second) {
		String url = "jdbc:h2:tcp://localhost/./s2032127";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "user", "pass");
			String sql = "INSERT INTO rireki(ID,県,市,日付,時刻) VALUES(?,?,?,?,?)";
			PreparedStatement pre = conn.prepareStatement(sql);
			String datestr = String.format("%4d-%02d-%02d", year, month, day);
			Date date = Date.valueOf(datestr);
			String timestr = String.format("%02d:%02d:%02d", hour, minute, second);
			Time time = Time.valueOf(timestr);
			pre.setInt(1, ID);
			pre.setInt(2, kencode);
			pre.setInt(3,shicode);
			pre.setDate(4, date);
			pre.setTime(5, time);;
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


/* 
public boolean insert(String newnumber,String newshicode) {
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
		conn  = DriverManager.getConnection(url, "user", "pass");
		String sql= "insert into store(番号,市コード) values(?,?)";
		PreparedStatement  pre= conn.prepareStatement(sql);
		pre.setString(1,newnumber);
		pre.setString(2, newshicode);
		int result = pre.executeUpdate();
		if(result == 1)return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		if(conn != null) {
			
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return false;
}*/
}
