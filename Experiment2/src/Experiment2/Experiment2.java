package Experiment2;

public class Experiment2 {
	public static void main(String[] args) {
		Goods[] boxGoods = new Goods[5];
		Goods[] bulkGoods = new Goods[5];
		String[] name2 = { "苹果", "香蕉", "梨", "芒果", "葡萄" };// 散装商品的名称
		String[] name1 = { "可乐", "牛奶", "饼干", "纸巾", "书" };// 盒装商品的名称
		int[] price2 = { 7, 5, 4, 10, 6 };// 散装商品的价格
		int[] price1 = { 3, 4, 8, 5, 30 };// 盒装商品的价格
		String code = "";
		String fileName1 = "SalesRecord.txt";
		String barCode = null;
		// int price = 0;

		for (int i = 0; i < 5; i++) {// 盒装商品的产生

			// price = (int)(Math.random()*30);//盒装商品价钱的产生
			barCode = "" + (693747631 + i);// 盒装商品条码的产生
			boxGoods[i] = new Goods(name1[i], barCode, price1[i]);
		}

		for (int i = 0; i < 5; i++) {// 散装商品的产生

			// price = (int)(Math.random()*11);//散装商品价钱的产生
			barCode = "" + (693747631 + i + 5);// 盒装商品条码的产生
			bulkGoods[i] = new Goods(name2[i],price2[i]);
		}

		SalesRecord[] records = new SalesRecord[200];// 定义销售记录对象数组
		double[] sum1 = new double[5];//各项盒装商品的总额数组
		double[] sum2 = new double[5];//各项散装商品的总额数组

		for (int i = 0; i < 200; i++) {// 商品销售记录的循环产生
			int flag = (int) (Math.random() * 10);//随机选取盒装或者散装
			if (flag / 2 == 0) {// 盒装商品销售记录的产生
				int j = (int) (Math.random() * 5);//随机选取盒装商品的的其中一种
				//sum1[j] = sum1[j] + boxGoods[j].getUnitprice();//每个单项盒装商品的总金额的产生
				records[i] = new SalesRecord(boxGoods[j]);//产生盒装商品的销售记录
			} 
			else {// 散装商品销售记录的产生
				int j = (int) (Math.random() * 5);//随机选取散装商品的的其中一种
				int n = (int) (Math.random() * 10);//随机产生散装商品的销售量
				records[i] = new SalesRecord(bulkGoods[j], n);//产生散装商品的销售记录
				//sum2[j] = sum2[j] + n * bulkGoods[j].getUnitprice();//每个单项散装商品的总金额的产生
			}
		}
		FileIn fi = new FileIn(fileName1);
		fi.fileIn(records);
		double sum = 0, sumBoxGoods = 0, sumBulkGoods = 0;//销售总额，盒装商品的销售总额，散装商品的销售总额
		
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
			sumBoxGoods = sum1[i] + sumBoxGoods;//计算盒装商品的销售总额
			sumBulkGoods = sum2[i] + sumBulkGoods;//计算散装商品的销售总额
		}
		String fileName2 = "result.txt";
		sum = sumBoxGoods + sumBulkGoods;//计算总金额
		ResultIn ri = new ResultIn(fileName2);
		code = code+"今天的销售总额为：" + sum;
		ri.resultIn(code);
		String code1 =" 盒装商品的销售总额为：" + sumBoxGoods;
		ri.resultIn(code1);
		String code2 = " 散装商品的销售总额为：" + sumBulkGoods;
		ri.resultIn(code2);
		for (int i = 0; i < 5; i++) {
			String str1 = name1[i] + "的销售额为：" + sum1[i];
			String str2 = name2[i] + "的销售额为：" + sum2[i];
			ri.resultIn(str1);
			ri.resultIn(str2);
		}
	}

}
