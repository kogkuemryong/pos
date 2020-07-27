package finalSemiProj;

class Benefit {
	static private int mulSBenefit;
	static private int mulMBenefit;
	static private int mulLBenefit;
	
	static private int bibimSBenefit;
	static private int bibimMBenefit;
	static private int bibimLBenefit;
	
	static private int haeSBenefit;
	static private int haeMBenefit;
	static private int haeLBenefit;
	
	static private int mandooBenefit;
	static private int goggiBenefit;
	
	static private int totalMulBenefit;
	static private int totalBibimBenefit;
	static private int totalHaeBenefit;
	
	static private int totalBenefit;

	Benefit() {	}

	
	// 물냉면 매출액
	static public void mulBenefit(int choice) {
		if (choice == 0) {
			mulSBenefit += 6000;
		} else if (choice == 1) {
			mulMBenefit += 6500;
		} else if (choice == 2) {
			mulLBenefit += 7000;
		}	
		calMulBenfit();
	}

	static public void calMulBenfit() { 
		totalMulBenefit = (getMulSBenefit() + getMulMBenefit() + getMulLBenefit());
		calTotalBenefit();
	}
	
	
	// 비빔냉면 매출액
	static public void bibimBenefit(int choice) {
		if (choice == 3) {
			bibimSBenefit += 6000;
		} else if (choice == 4) {
			bibimMBenefit += 6500;
		} else if (choice == 5) {
			bibimLBenefit += 7000;
		}	
		calBibimBenfit();
	}
	
	static public void calBibimBenfit() { 
		totalBibimBenefit = (getBibimSBenefit() + getBibimMBenefit() + getBibimLBenefit());
		calTotalBenefit();
	}
	
	
	
	// 회냉면 매출액
	static public void haeBenefit(int choice) {
		if(choice == 6) {
			haeSBenefit += 7000;
		}else if(choice == 7) {
			haeMBenefit +=7500;
		}else if(choice == 8) {
			haeLBenefit += 8000;
		}
		calHaeBenefit();
	}
	
	static public void calHaeBenefit() {
		totalHaeBenefit = (getHaeSBenefit() + getHaeMBenefit() + getHaeLBenefit());
		calTotalBenefit();
	}
	
	
	
	// 추가메뉴 매출액
	static public void mandooBenefit(int choice) {
		mandooBenefit += 4000;
		calTotalBenefit();
	}
	
	static public void goggiBenefit(int choice) {
		goggiBenefit += 6000;
		calTotalBenefit();
	}
	
	
	
	 // 최종 당일 총 매출액
	static public void calTotalBenefit() {
		totalBenefit = (getTotalMulBenefit() + getTotalBibimBenefit() + getTotalHaeBenefit() + getMandooBenefit() + getGoggiBenefit());
	}
	
	
	
	
	
	
	
	public static int getBibimSBenefit() {
		return bibimSBenefit;
	}

	public static int getBibimMBenefit() {
		return bibimMBenefit;
	}

	public static int getBibimLBenefit() {
		return bibimLBenefit;
	}

	public static int getHaeSBenefit() {
		return haeSBenefit;
	}

	public static int getHaeMBenefit() {
		return haeMBenefit;
	}

	public static int getHaeLBenefit() {
		return haeLBenefit;
	}

	static public int getMulSBenefit() {
		return mulSBenefit;
	}

	public static int getMulMBenefit() {
		return mulMBenefit;
	}

	public static int getMulLBenefit() {
		return mulLBenefit;
	}

	
	
	
	
	public static int getMandooBenefit() {
		return mandooBenefit;
	}

	public static int getGoggiBenefit() {
		return goggiBenefit;
	}
	
	
	
	
	public static int getTotalMulBenefit() {
		return totalMulBenefit;
	}

	public static int getTotalBibimBenefit() {
		return totalBibimBenefit;
	}

	public static int getTotalHaeBenefit() {
		return totalHaeBenefit;
	}

	
	public static int getTotalBenefit() {
		return totalBenefit;
	}

	
	
	
	
	
	
	

	public static void setMandooBenefit(int mandooBenefit) {
		Benefit.mandooBenefit = mandooBenefit;
	}


	public static void setGoggiBenefit(int goggiBenefit) {
		Benefit.goggiBenefit = goggiBenefit;
	}


	public static void setTotalMulBenefit(int totalMulBenefit) {
		Benefit.totalMulBenefit = totalMulBenefit;
	}


	public static void setTotalBibimBenefit(int totalBibimBenefit) {
		Benefit.totalBibimBenefit = totalBibimBenefit;
	}


	public static void setTotalHaeBenefit(int totalHaeBenefit) {
		Benefit.totalHaeBenefit = totalHaeBenefit;
	}


	public static void setTotalBenefit(int totalBenefit) {
		Benefit.totalBenefit = totalBenefit;
	}
	
	
}
