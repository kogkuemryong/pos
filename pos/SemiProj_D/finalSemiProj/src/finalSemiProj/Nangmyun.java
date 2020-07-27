package finalSemiProj;

class Nangmyun extends Stock{

	
	Nangmyun(int choice){
		int ss = calNoodle(choice);
		MinusStockNoodle(ss);		
	}

	// 냉면의 면재고량 (소:1개 / 중:2개 / 대:3개)
	public int calNoodle(int choice) {
		int n=0;
		
		if(choice == 0 || choice == 3 || choice==6) {
			n = 1;			
		}else if(choice == 1 || choice == 4 || choice==7) {
			n = 2;	
		}else if(choice == 2 || choice == 5 || choice==8) {
			n = 3;	
		}	
		return n;
	}

	
	// 냉면의 공통재료와 특수재료의 재고량(물냉:육수 / 회냉:회)
	public void calComStock(int choice) {	
		
		if(choice == 0 || choice == 1 || choice==2) {
			MinusStockYuksu(1);		
		}else if(choice == 3 || choice == 4 || choice==5) {
			
		}else if(choice == 6 || choice == 7 || choice==8) {
			MinusStockHae(1);
		}
		MinusStockEgg(1);
		MinusStockGomungGoggi(1);
		MinusStockMu(1);
		MinusStockOi(1);	
		}
}	
