package com.bank.util;

import java.util.UUID;

public class Uuid {
	public static String uuidCard() {
		int machineId = 2; //���֧��1-9����Ⱥ��������
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//�п����Ǹ���
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%011d", hashCodeV);
	}
	
	public static String uuidPno() {
		int machineId = 3; //���֧��1-9����Ⱥ��������
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//�п����Ǹ���
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%011d", hashCodeV);
	}
	
	public static int uuidInt() {
		int machineId = 1; //���֧��1-9����Ⱥ��������
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//�п����Ǹ���
			hashCodeV = -hashCodeV;
		}
		
		String str = machineId + String.format("%011d", hashCodeV);
		
		return Integer.parseInt(str.substring(0, 6));
	}
	
	public static void main(String[] args) {
		System.out.println("�˺ţ�" + uuidInt());
	}

}
