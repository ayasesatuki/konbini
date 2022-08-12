package db;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppearMain {
void insert(int number, int shicode) {
AppearDAO appearDAO = new AppearDAO();
boolean success = appearDAO.insert(number, shicode);

System.out.println(success);
}
void allAppear() {
	AppearDAO appearDAO = new AppearDAO();
	 List<Appear> list = null;
	try {
		list = AppearDAO.findAll();
		
	} catch (Exception e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}
	for (Appear p :list) {
		int id = p.getId();
		String name = p.getName();
		String ken = p.getKen();
		String shi = p.getShi();
		Date date = p.getDate();
		Time time = p.getTime();
		int number = p.getNumber();

		System.out.printf("%3d %-10s %-10s %-10s %-10s %-10s %-10s \n",id,number,ken,shi,date,time,name);

	}
	}
void insert(int number, int shicode,
		int year, int month, int day, int hour, int minute, int second) {
	AppearDAO appearDAO = new AppearDAO();
	boolean success = appearDAO.insert(number, shicode , year, month,day, hour, minute,second);
	System.out.println(success);
}

void delete(int id) {
	AppearDAO appearDAO = new AppearDAO();
	boolean success = appearDAO.delete(id);
	System.out.println(success);
	}
void selectAll() {
	AppearDAO appearDAO = new AppearDAO();
	boolean success = appearDAO.narabikae("番号","desc");
	System.out.println(success);
}
public static void main(String args[]) {
AppearMain main = new AppearMain();
//main.insert(6, 12206);
//main.insert(6,12206,2022,5, 9, 21, 21, 31);
//main.delete(1);
main.selectAll();
main.allAppear();

}
}