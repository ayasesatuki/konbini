
package db;

import java.sql.Date;
import java.sql.Time;

/** テーブルpokemonのデータを保持するクラス */
public class Appear {
 /** 番号 */
 private int id;
 /** 名前 */
 private int number;
 /** 攻撃力 */
 private String ken;
 /** 防御力 */
 private String shi;
 /** 体力 */
 private Date date;
 /** 最大CP */
 private Time time;
private String name;
//private int number;

public Appear(int id, int number, String ken, String shi, Date date, Time time,String name) {
	this.id = id;
	this.number = number;
	this.ken = ken;
	this.shi = shi;
	this.date = date;
	this.time = time;
	this.name = name;
	// TODO 自動生成されたコンストラクター・スタブ
}

public int getId() {
	return id;
}
public int getNumber() {
	return number;
}
public String getKen() {
	return ken;
}
public String getShi() {
	return shi;
}
public Date getDate() {
	return date;
}
public Time getTime() {
	return time;
}
/** コンストラクタ */
public String getName() {
	return name;
}
 }