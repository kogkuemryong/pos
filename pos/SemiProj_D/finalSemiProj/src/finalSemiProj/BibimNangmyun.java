package finalSemiProj;

class BibimNangmyun extends Nangmyun{
	
	BibimNangmyun(int choice){
		super(choice);
		calComStock(choice);
		Benefit.bibimBenefit(choice);
	}
	
}
