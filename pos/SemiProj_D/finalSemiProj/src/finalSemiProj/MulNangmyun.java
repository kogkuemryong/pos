package finalSemiProj;

class MulNangmyun extends Nangmyun{
	
	MulNangmyun(int choice){
		super(choice);
		calComStock(choice);		
		Benefit.mulBenefit(choice);	
	}

}
