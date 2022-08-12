package Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	int games = 0;
	
	/** 現在のチップ数 初期値は500 */
	 int chips;
	 /** 山札 */
	 List<Integer> deckcards;
	 /** 手札 */
	 List<Integer> handcards;
	 /** 送信ボタンに表示する文字列("交換","次のゲーム"のどちらか */
	 String buttonLabel;
	 /** プレイヤーへのメッセージ */
	 String message;
	
	public PokerModel(){
		games = 0;
		deckcards = new ArrayList<>();
		handcards = new ArrayList<>();
		
	}
	
	public void nextgame() {
		
		deckcards.clear();
		
		 for (int i=1; i<=52; i++) {
		 deckcards.add(i);
		 }
		
		 handcards.clear();
		 for (int i=0; i<5; i++) {
		 int n = deckcards.remove(0);
		 Collections.shuffle(deckcards);
		 handcards.add(n);
		 }
		// 残りの場札の枚数とカード番号をコンソールに表示する
		 System.out.printf("%d: ", deckcards.size());
		 for (int n: deckcards) {
		 System.out.printf("%d ", n);
		 }
		 System.out.println();
		 message = "交換するカードをチェックしてください";
		 buttonLabel = "交換";
		 
		 
		 
		 games++;



	}
	public void reset() {
		games = 0;
		chips = 500;
		

	}
	public int getGames() {
	return games;
	}
	
	 /** 現在のチップ数を返す */
	 public int getChips() {
	 return chips;
	 }
	 /** 5枚の手札のうち，i番目のカード番号を返す (i=0～4) */
	 public int getHandcardAt(int i) {
	 return handcards.get(i);
	 }
	 
	 
	 /** 送信ボタンのラベルを返す */
	 public String getButtonLabel() {
	 return buttonLabel;
	 }
	 /** プレイヤーへのメッセージを返す */
	 public String getMessage() {
		 return message;
	 }
	 
	 /** indexで指定された位置のカードを、山札から補充したカードを置き換える */
	 public void change(List<String> index) {
	 System.out.println("index="+index);
	 //for(int count = 0 ; count <= index.length) {
	
	 //}

	 
	 for (int i=0; i<index.size(); i++) {
		 int num = Integer.parseInt(index.get(i));
		 int c = deckcards.remove(0); // 山札の先頭を取り除き、
		 handcards.set(num, c); // 手札の指定場所に入れる
	 }
	 evaluate();
	 buttonLabel = "次のゲーム";
	 }
	 /** 役の判別を行い、チップを増減させる */
	 void evaluate() {
	 chips -= 100;
	 message = "ノーペアです -100";
	 if (chips == 0) {
	 message += " ゲームオーバー";
	 }
	 }


}

