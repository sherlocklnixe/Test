package ���ű�;

import java.util.Arrays;
import java.util.Scanner;

public class Fouthday2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//����һ������ nums ��һ��ֵ val������Ҫԭ���Ƴ�������ֵ���� val ��Ԫ�أ������Ƴ���������³��ȡ�

		//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

		//Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
		Scanner sc=new Scanner(System.in);
		int num[]={0,1,2,2,3,0,4,2};
		int len=delete(num,2);
		System.out.println(len);
		System.out.println(Arrays.toString(num));
		


	}

	private static int delete(int[] num, int var) {
		// TODO �Զ����ɵķ������
		int j = 0;
		for (int i = 0; i < num.length; i++)
		{ 
			if (num[i] != var) { 
			num[j++] = num[i];
		} 
		} 
		return j; 


	
		
	}

}
