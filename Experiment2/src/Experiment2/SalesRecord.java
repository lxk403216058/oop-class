package Experiment2;

public class SalesRecord {
	
	private Goods goods = null;// �����۵���Ʒ
	private float amount = 1;// ��Ʒ��������װ��ƷΪ1��ɢװ��ƷΪʵ������
	static java.util.Date time = new java.util.Date();// ���ڻ��ʱ��ĺ�����
    private static long recordID = (time.getTime() / 1000 / 60 / 60 / 24 % 10000);// ��Ʒ���۱��
    
	// ���ݷ�����
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

	// ��װ��Ʒ�����ۼ�¼
	public SalesRecord(Goods goods) {
		this.goods = goods;
		recordID++;
	}

	// ɢװ��Ʒ�����ۼ�¼
	public SalesRecord(Goods goods, float amount) {
		this.goods = goods;
		this.amount = amount;
		recordID++;
	}
	
	// ɢװ��Ʒ�ļƼ۷���
	public double getFare() {
		return goods.getUnitprice() * amount;
	}
}
