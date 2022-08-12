
package db;

import java.sql.Date;
import java.sql.Time;

/** テーブルpokemonのデータを保持するクラス */
public class Convin {
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
 private Time time;
private String name;
//チェーン名
private String chain;
private String mise;
//private int number;

public Convin(int id, String ken, String shi, Date date, Time time,String name,String chain) {
	this.id = id;
	//this.number = number;
	this.ken = ken;
	this.shi = shi;
	this.date = date;
	this.time = time;
	this.name = name;
	this.chain = chain;
	// TODO 自動生成されたコンストラクター・スタブ
}

public Convin(int id, String ken, String shi, String chain) {
	// TODO 自動生成されたメソッド・スタブ
	this.id = id;
	this.ken = ken;
	this.shi = shi;
	this.chain = chain;
	
}


public Convin(int id, String ken, String shi, String chain, String mise) {
	this.id = id;
	this.ken = ken;
	this.shi = shi;
	//this.date = date;
	//this.time = time;
	//this.name = name;
	this.chain = chain;
	this.mise = mise;
}

public Convin(int id, String ken, String shi, String chain, String mise, Date date, Time time) {
	this.id = id;
	this.ken = ken;
	this.shi = shi;
	this.date = date;
	this.time = time;
	//this.name = name;
	this.chain = chain;
	this.mise = mise;
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

public String getChain() {
	return chain;
}

public String getMise() {
	return mise;
}
 }