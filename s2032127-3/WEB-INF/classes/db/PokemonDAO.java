package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/** テーブルpokemon用のDAO */
public class PokemonDAO {
 /** プログラム起動時に一度だけ実行される */
 static {
 try {
 Class.forName("org.h2.Driver"); // JDBC Driverの読み込み
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 public List<Pokemon> findAll() {
 List<Pokemon> list = new ArrayList<>();
 String url = "jdbc:h2:tcp://localhost/./s2032127";
 Connection conn = null;
 try {
 conn = DriverManager.getConnection(url, "user", "pass");
 String sql = "SELECT * FROM pokemon";
 PreparedStatement pre = conn.prepareStatement(sql);
 ResultSet rs = pre.executeQuery();
 while (rs.next()) {
	 int id = rs.getInt("番号");
	 String name = rs.getString("名前");
	 int attack = rs.getInt("攻撃力");
	 int defense = rs.getInt("防御力");
	 int stamina = rs.getInt("体力");
	 int cp = rs.getInt("最大CP");
 Pokemon p = new Pokemon(id, name, attack, defense, stamina, cp);
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
 public List<Pokemon>pikachu(){
	 List<Pokemon> list = new ArrayList<>();
	 String url = "jdbc:h2:tcp://localhost/./s2032127";
	 Connection conn = null;
	 try {
	 conn = DriverManager.getConnection(url, "user", "pass");
	 String sql = " SELECT 攻撃力,防御力,体力 FROM pokemon where 名前 = \'ピカチュウ\'";
	 PreparedStatement pre = conn.prepareStatement(sql);
	 ResultSet rs = pre.executeQuery();
	 while (rs.next()) {
	 //int id = rs.getInt("番号");
	 //String name = rs.getString("名前");
	 int attack = rs.getInt("攻撃力");
	 int defense = rs.getInt("防御力");
	 int stamina = rs.getInt("体力");
	 //int cp = rs.getInt("最大CP");
	 Pokemon p = new Pokemon(0, "", attack, defense, stamina, 0);
	 //okemon p = new Pokemon(name);
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
 

 public List<Pokemon>threeLetters(){
	 List<Pokemon> list = new ArrayList<>();
	 String url = "jdbc:h2:tcp://localhost/./s2032127";
	 Connection conn = null;
	 try {
	 conn = DriverManager.getConnection(url, "user", "pass");
	 String sql = " SELECt 名前 from pokemon where char_length(名前) = 3";
	 PreparedStatement pre = conn.prepareStatement(sql);
	 ResultSet rs = pre.executeQuery();
	 while (rs.next()) {
	 //int id = rs.getInt("番号");
	 String name = rs.getString("名前");
	 //int attack = rs.getInt("攻撃力");
	 //int defense = rs.getInt("防御力");
	 //int stamina = rs.getInt("体力");
	 //int cp = rs.getInt("最大CP");
	 //System.out.println(name);
	 
	 Pokemon p = new Pokemon(0, name, 0, 0,0, 0);
	 //okemon p = new Pokemon(name);
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
	 }return list;
	 
	 
	 }
	 public List<Pokemon>max(){
		 List<Pokemon> list = new ArrayList<>();
		 String url = "jdbc:h2:tcp://localhost/./s2032127";
		 Connection conn = null;
		 try {
		 conn = DriverManager.getConnection(url, "user", "pass");
		 String sql = " SELECT max(攻撃力) , max(防御力),max(体力) from pokemon ";
		 PreparedStatement pre = conn.prepareStatement(sql);
		 ResultSet rs = pre.executeQuery();
		 while (rs.next()) {
		 //int id = rs.getInt("番号");
		 //String name = rs.getString("名前");
		 
		 //int cp = rs.getInt("最大CP");
		 //System.out.println(name);
		 int maxattack = rs.getInt("MAX(攻撃力)");
	     int maxdefense = rs.getInt("MAX(防御力)");
		 int maxstamina = rs.getInt("MAX(体力)");
		 //System.out.print(maxattack);
		 Pokemon p = new Pokemon(maxattack,maxdefense,maxstamina);
		 //okemon p = new Pokemon(name);
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
	 
	 public List<Pokemon>denki(){
		 List<Pokemon> list = new ArrayList<>();
		 String url = "jdbc:h2:tcp://localhost/./s2032127";
		 Connection conn = null;
		 try {
		 conn = DriverManager.getConnection(url, "user", "pass");
		 String sql = " SELECT pokemon.番号,名前,攻撃力,防御力,体力,最大CP,タイプ FROM pokemon\n"
		 		+ "JOIN type ON pokemon.番号=type.番号 WHERE タイプ = 'でんき'";
		 PreparedStatement pre = conn.prepareStatement(sql);
		 ResultSet rs = pre.executeQuery();
		 while (rs.next()) {
			 int id = rs.getInt("番号");
			 String name = rs.getString("名前");
			 int attack = rs.getInt("攻撃力");
			 int defense = rs.getInt("防御力");
			 int stamina = rs.getInt("体力");
			 int cp = rs.getInt("最大CP");
			 String type = rs.getString("タイプ");
		 Pokemon p = new Pokemon(id, name, attack, defense, stamina, cp,type);
		 //okemon p = new Pokemon(name);
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
}
