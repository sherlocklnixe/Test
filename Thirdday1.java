package 蓝桥杯;

import java.util.Arrays;

public class Thirdday1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//输出一个数组的子集
		int[] num={1,2,3,4};
		
		int k=0;
	
		for(int i=3;i>=0;i--){
			int[] num1=new int[i+1];
			for(int j=0;j<=i;j++){
				num1[j]=num[j];
				System.out.println(Arrays.toString(num1));
				}
			}
			
			
		

	}

}
