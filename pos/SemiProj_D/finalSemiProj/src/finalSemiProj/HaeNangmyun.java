package finalSemiProj;

class HaeNangmyun extends Nangmyun{
	
	HaeNangmyun(int choice) {
		super(choice);
		calComStock(choice);
		Benefit.haeBenefit(choice);
	}

}
