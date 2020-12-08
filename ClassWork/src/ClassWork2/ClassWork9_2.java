package ClassWork2;

public class ClassWork9_2 {
	public static void main(String[] args) {
		Stock s1;
		
		s1=new Stock("ORCL","Oracle Corporation",34.5,34.35);
		System.out.println("ORCL's stock change: "+s1.getChangePrecent()+"%");
	}

}
class Stock{
	String symbol;
	String name;
	double previousClosingPrice,currentPrice;
	
	public Stock(String symbol,String name,double previousClosingPrice,double currentPrice) {
		this.symbol=symbol;
		this.name=name;
		this.previousClosingPrice=previousClosingPrice;
		this.currentPrice=currentPrice;
	}
	
	double getChangePrecent() {
		return (currentPrice-previousClosingPrice)/previousClosingPrice*100;
	}
}
