package Experiment2;

//��Ʒ��
public class Goods {
	private String goodsName = null;// ��Ʒ����
	private boolean boxPacked = true;// �ж��Ƿ�Ϊ��װ��ƷtrueΪ��װ��ƷflaseΪɢװ��Ʒ
	private String barCode = null;// ��Ʒ�����룬ֻ�к�װ��Ʒ����
	private int unitPrice = 0;// ����

	// ���ݷ�����
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

	// ��װ��Ʒ�Ĺ��췽��
	public Goods(String goodsName, String barCode, int unitPrice) {
		this.goodsName = goodsName;
		this.barCode = barCode;
		this.unitPrice = unitPrice;
	}

	// ɢװ��Ʒ���췽��
	public Goods(String goodsName, int unitPrice) {
		this.goodsName = goodsName;
		this.unitPrice = unitPrice;
		boxPacked = false;
	}

}
