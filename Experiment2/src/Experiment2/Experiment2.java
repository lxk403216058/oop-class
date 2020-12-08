package Experiment2;

public class Experiment2 {
	public static void main(String[] args) {
		Goods[] boxGoods = new Goods[5];
		Goods[] bulkGoods = new Goods[5];
		String[] name2 = { "ƻ��", "�㽶", "��", "â��", "����" };// ɢװ��Ʒ������
		String[] name1 = { "����", "ţ��", "����", "ֽ��", "��" };// ��װ��Ʒ������
		int[] price2 = { 7, 5, 4, 10, 6 };// ɢװ��Ʒ�ļ۸�
		int[] price1 = { 3, 4, 8, 5, 30 };// ��װ��Ʒ�ļ۸�
		String code = "";
		String fileName1 = "SalesRecord.txt";
		String barCode = null;
		// int price = 0;

		for (int i = 0; i < 5; i++) {// ��װ��Ʒ�Ĳ���

			// price = (int)(Math.random()*30);//��װ��Ʒ��Ǯ�Ĳ���
			barCode = "" + (693747631 + i);// ��װ��Ʒ����Ĳ���
			boxGoods[i] = new Goods(name1[i], barCode, price1[i]);
		}

		for (int i = 0; i < 5; i++) {// ɢװ��Ʒ�Ĳ���

			// price = (int)(Math.random()*11);//ɢװ��Ʒ��Ǯ�Ĳ���
			barCode = "" + (693747631 + i + 5);// ��װ��Ʒ����Ĳ���
			bulkGoods[i] = new Goods(name2[i],price2[i]);
		}

		SalesRecord[] records = new SalesRecord[200];// �������ۼ�¼��������
		double[] sum1 = new double[5];//�����װ��Ʒ���ܶ�����
		double[] sum2 = new double[5];//����ɢװ��Ʒ���ܶ�����

		for (int i = 0; i < 200; i++) {// ��Ʒ���ۼ�¼��ѭ������
			int flag = (int) (Math.random() * 10);//���ѡȡ��װ����ɢװ
			if (flag / 2 == 0) {// ��װ��Ʒ���ۼ�¼�Ĳ���
				int j = (int) (Math.random() * 5);//���ѡȡ��װ��Ʒ�ĵ�����һ��
				//sum1[j] = sum1[j] + boxGoods[j].getUnitprice();//ÿ�������װ��Ʒ���ܽ��Ĳ���
				records[i] = new SalesRecord(boxGoods[j]);//������װ��Ʒ�����ۼ�¼
			} 
			else {// ɢװ��Ʒ���ۼ�¼�Ĳ���
				int j = (int) (Math.random() * 5);//���ѡȡɢװ��Ʒ�ĵ�����һ��
				int n = (int) (Math.random() * 10);//�������ɢװ��Ʒ��������
				records[i] = new SalesRecord(bulkGoods[j], n);//����ɢװ��Ʒ�����ۼ�¼
				//sum2[j] = sum2[j] + n * bulkGoods[j].getUnitprice();//ÿ������ɢװ��Ʒ���ܽ��Ĳ���
			}
		}
		FileIn fi = new FileIn(fileName1);
		fi.fileIn(records);
		double sum = 0, sumBoxGoods = 0, sumBulkGoods = 0;//�����ܶ��װ��Ʒ�������ܶɢװ��Ʒ�������ܶ�
		
		FileOut fo = new FileOut(fileName1);
		for (int i = 0;i < fo.fileOut().length;i ++){
			for (int j = 0;j < 5;j++){
				if (fo.fileOut()[i].getGoods().getGoodsName().equals(name1[j])){
				    sum1[j] = sum1[j]+fo.fileOut()[i].getFare();
				    break;
			    }
				else if(fo.fileOut()[i].getGoods().getGoodsName().equals(name2[j])){
					sum2[j] = sum2[j] + fo.fileOut()[i].getFare();
					break;
					}
			}
		}
		for (int i = 0; i < 5; i++) {
			sumBoxGoods = sum1[i] + sumBoxGoods;//�����װ��Ʒ�������ܶ�
			sumBulkGoods = sum2[i] + sumBulkGoods;//����ɢװ��Ʒ�������ܶ�
		}
		String fileName2 = "result.txt";
		sum = sumBoxGoods + sumBulkGoods;//�����ܽ��
		ResultIn ri = new ResultIn(fileName2);
		code = code+"����������ܶ�Ϊ��" + sum;
		ri.resultIn(code);
		String code1 =" ��װ��Ʒ�������ܶ�Ϊ��" + sumBoxGoods;
		ri.resultIn(code1);
		String code2 = " ɢװ��Ʒ�������ܶ�Ϊ��" + sumBulkGoods;
		ri.resultIn(code2);
		for (int i = 0; i < 5; i++) {
			String str1 = name1[i] + "�����۶�Ϊ��" + sum1[i];
			String str2 = name2[i] + "�����۶�Ϊ��" + sum2[i];
			ri.resultIn(str1);
			ri.resultIn(str2);
		}
	}

}
