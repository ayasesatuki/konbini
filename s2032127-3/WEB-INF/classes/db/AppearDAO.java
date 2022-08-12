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
/** テーブルappear用のDAO */
public class AppearDAO {
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
String sql = "INSERT INTO appear(番号,市コード) VALUES(?,?)";
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


public static  List<Appear> findAll() {
List<Appear> list = new ArrayList<>();
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "select ID,appear.番号,県名,時刻,日付,pokemon.名前,市名 from appear inner join pokemon on appear.番号 = pokemon.番号 \n"
		+ "inner join shi on shi.市コード = appear.市コード inner join ken on shi.県コード = ken.県コード; ";
PreparedStatement pre = conn.prepareStatement(sql);
ResultSet rs = pre.executeQuery();
while (rs.next()) {
	 int id = rs.getInt("ID");
	 int number = rs.getInt("番号");
	 String name = rs.getString("名前");
	 String ken = rs.getString("県名");
	 String shi = rs.getString("市名");
	 Date date = rs.getDate("日付");
	 Time time = rs.getTime("時刻");
Appear p = new Appear(id , number , ken , shi , date ,time , name);
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
public boolean insert(int number, int shicode,
int year, int month, int day, int hour, int minute, int second) {
String url = "jdbc:h2:tcp://localhost/./s2032127";
Connection conn = null;
try {
conn = DriverManager.getConnection(url, "user", "pass");
String sql = "INSERT INTO appear(番号,市コード,日付,時刻) VALUES(?,?,?,?)";
PreparedStatement pre = conn.prepareStatement(sql);
String datestr = String.format("%4d-%02d-%02d", year, month, day);
Date date = Date.valueOf(datestr);
String timestr = String.format("%02d:%02d:%02d", hour, minute, second);
Time time = Time.valueOf(timestr);
pre.setInt(1, number);
pre.setInt(2, shicode);
pre.setDate(3, date);
pre.setTime(4, time);;
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
	//String sql = "delete from appear where id = appear(id) VALUES(?)";
	String sql = "DELETE FROM appear WHERE ID=?";
	
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

public boolean narabikae(String item,String order) {
	System.out.println(item);
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
		conn = DriverManager.getConnection(url, "user", "pass");
		//String sql = "delete from appear where id = appear(id) VALUES(?)";
		String sql = "";
		if( order =="desc") {
			sql = "SELECT * from appear order by " + item +" desc";
		}else {
			sql = "SELECT * from appear order by " + item ;
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
		
	
}


/* 
public boolean insert(String newnumber,String newshicode) {
	String url = "jdbc:h2:tcp://localhost/./s2032127";
	Connection conn = null;
	try {
		conn  = DriverManager.getConnection(url, "user", "pass");
		String sql= "insert into appear(番号,市コード) values(?,?)";
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
