package finalSemiProj;

import java.util.ArrayList;
import java.util.Iterator;

class Stock {
	private static int noodle=300;
	private static int yuksu=100;
	private static int gomung_mu=300;
	private static int gomung_egg=300;
	private static int gomung_goggi=300;
	private static int gomung_oi=300;
	private static int hae=300;
	private static int goggi=200;
	private static int mandoo=200;	
	
//	MenuDAO dao = new MenuDAO();
//	ArrayList<Stock> s = new ArrayList<Stock>();
//	Iterator<Stock> i = s.iterator();
//	
//	Stock(){
//		s = dao.selectStock();
//		this.noodle = i.next();
//	}
//	
	
	
	
	
	
	public static int getNoodle() {
		return noodle;
	}
	public void setNoodle(int noodle) {
		this.noodle = noodle;
	}
	public static int getYuksu() {
		return yuksu;
	}
	public void setYuksu(int yuksu) {
		this.yuksu = yuksu;
	}
	public static int getGomung_mu() {
		return gomung_mu;
	}
	public void setGomung_mu(int gomung_mu) {
		this.gomung_mu = gomung_mu;
	}
	public static int getGomung_egg() {
		return gomung_egg;
	}
	public void setGomung_egg(int gomung_egg) {
		this.gomung_egg = gomung_egg;
	}
	public static int getGomung_goggi() {
		return gomung_goggi;
	}
	public void setGomung_goggi(int gomung_goggi) {
		this.gomung_goggi = gomung_goggi;
	}
	public static int getGomung_oi() {
		return gomung_oi;
	}
	public void setGomung_oi(int gomung_oi) {
		this.gomung_oi = gomung_oi;
	}
	public static int getHae() {
		return hae;
	}
	public void setHae(int hae) {
		this.hae = hae;
	}
	public static int getGoggi() {
		return goggi;
	}
	public void setGoggi(int goggi) {
		this.goggi = goggi;
	}
	public static int getMandoo() {
		return mandoo;
	}
	public void setMandoo(int mandoo) {
		this.mandoo = mandoo;
	}
	

	
	public void calExtraStock(int choice) {
		if(choice == 9) {
			MinusStockMandoo(1);
		}else if(choice ==10)
			MinusStockGoggi(1);
		}
	
	
	public void MinusStockNoodle(int noodle) {
		this.noodle -= noodle;
	}
	public void MinusStockYuksu(int yuksu) {
		this.yuksu -= yuksu;
	}
	public void MinusStockMu(int mu) {
		this.gomung_mu -= mu;
	}
	public void MinusStockEgg(int egg) {
		this.gomung_egg -= egg;
	}
	public void MinusStockGomungGoggi(int gg) {
		this.gomung_goggi -= gg;
	}
	public void MinusStockOi(int oi) {
		this.gomung_oi -=  oi;
	}
	public void MinusStockHae(int hae) {
		this.hae -= hae;
	}
	public void MinusStockGoggi(int gg) {
		this.goggi -= gg;
	}
	public void MinusStockMandoo(int md) {
		this.mandoo -= md;
	}
	
}


