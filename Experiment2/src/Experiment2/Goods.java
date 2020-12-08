package Experiment2;

//商品类
public class Goods {
	private String goodsName = null;// 商品名称
	private boolean boxPacked = true;// 判断是否为盒装商品true为盒装商品flase为散装商品
	private String barCode = null;// 商品条形码，只有盒装商品才有
	private int unitPrice = 0;// 单价

	// 数据访问器
	public String getGoodsName() {
		return goodsName;
	}

	public boolean getBoxPacked() {
		return boxPacked;
	}

	public String getBarCode() {
		return barCode;
	}

	public int getUnitprice() {
		return unitPrice;
	}

	// 盒装商品的构造方法
	public Goods(String goodsName, String barCode, int unitPrice) {
		this.goodsName = goodsName;
		this.barCode = barCode;
		this.unitPrice = unitPrice;
	}

	// 散装商品构造方法
	public Goods(String goodsName, int unitPrice) {
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
		boxPacked = false;
	}

}
