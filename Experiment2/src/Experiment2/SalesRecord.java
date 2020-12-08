package Experiment2;

public class SalesRecord {
	
	private Goods goods = null;// 所销售的商品
	private float amount = 1;// 商品数量，盒装商品为1，散装商品为实际数量
	static java.util.Date time = new java.util.Date();// 用于获得时间的毫秒数
    private static long recordID = (time.getTime() / 1000 / 60 / 60 / 24 % 10000);// 商品销售编号
    
	// 数据访问器
	public long getRecord() {
		return recordID++;
	}

	public Goods getGoods() {
		return goods;
	}

	public float getAmount() {
		return amount;
	}
	
	public void setAmount(float amount){
		this.amount = amount;
	}
	
	public SalesRecord(){
		
	}

	// 盒装商品的销售记录
	public SalesRecord(Goods goods) {
		this.goods = goods;
		recordID++;
	}

	// 散装商品的销售记录
	public SalesRecord(Goods goods, float amount) {
		this.goods = goods;
		this.amount = amount;
		recordID++;
	}
	
	// 散装商品的计价方法
	public double getFare() {
		return goods.getUnitprice() * amount;
	}
}
