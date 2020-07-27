package finalSemiProj;

import java.util.ArrayList;
import java.util.Scanner;

class NoodleController {
	Stock[] food;
	int index;
	
	NoodleController() {
		food = new Stock[500];
		index = 0;
	}

	
	// 메뉴선택
	public void addMenu(int choice) {

		Scanner key = new Scanner(System.in);
		
		if(choice == 0  || choice ==1 || choice ==2) {//물냉면 입력 받았을 떄 
			food[index] = new MulNangmyun(choice);
			index++;
//			System.out.println(Stock.getNoodle());
		}else if(choice == 3  || choice ==4 || choice ==5) {//비빔냉면 입력 받았을 때		
			food[index] = new BibimNangmyun(choice);
			index++;
		}else if(choice == 6  || choice ==7 || choice ==8) {
			food[index] = new HaeNangmyun(choice);
			index++;
		}else if(choice == 9) {
			food[index] = new Mandoo(choice);		
			index++;
		}else if(choice == 10) {
			food[index] = new Galbi(choice);		
			index++;
		}		
	}

	
	// 이익
	public int displayMulBenefit() {
		int mt = Benefit.getTotalMulBenefit();
//		System.out.println("물냉면 매출액: "+mt);
		return mt;
	}
	
	public int displayBibimBenefit() {
		int bt = Benefit.getTotalBibimBenefit();
//		System.out.println("비빔냉면 매출액 : "+bt);
		return bt;
	}
	
	public int displayHaeBenefit() {//회냉면 이윤 계산 안되고 있음!!!!!!!!!!!!!!!!
		int ht = Benefit.getTotalHaeBenefit();
//		System.out.println("회냉면 매출액 : "+ht);
		return ht;
	}
	
	public int displayTotalBenefit() {		
		int t = Benefit.getTotalBenefit();
//		System.out.println("오늘 총 매출액 :  "+t);
		return t;
	}
	
	
	public int displayBenefit(int choice) {
		int sal=0;
		
		if(choice == 0) {
			sal = displayMulBenefit();
		}else if(choice == 1) {
			sal = displayBibimBenefit();
		}else if(choice == 2) {
			sal = displayHaeBenefit();
		}else if(choice == 3) {
			sal = Benefit.getMandooBenefit();
		}else if(choice ==4) {
			sal = Benefit.getGoggiBenefit();
		}
		
		return sal;
	}
	
	
	
	
	
	
	
	public static int getStock(int choice) {
		int inventory=0;
		
		if(choice == 0) {
			inventory = Stock.getNoodle();
		}else if(choice == 1) {
			inventory = Stock.getYuksu();
		}else if(choice == 2) {
			inventory = Stock.getGomung_egg();
		}else if(choice == 3) {
			inventory = Stock.getGomung_oi();
		}else if(choice == 4) {
			inventory = Stock.getGomung_goggi();
		}else if(choice == 5) {
			inventory = Stock.getGomung_mu();
		}else if(choice == 6) {
			inventory = Stock.getHae();
		}else if(choice == 7) {
			inventory = Stock.getMandoo();
		}else if(choice == 8) {
			inventory = Stock.getGoggi();
		}
		return inventory;
		
	}	
	
	
}


	
	

	
	

	
	

