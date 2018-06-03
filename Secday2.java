package 蓝桥杯;

import java.util.Arrays;

public class Secday2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num= {7,3,5,8,2,1};
		int[] num1=new int[15];
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				int m=num[i]-num[j];
					for(int k=0;k<num1.length;k++){
						num1[k]=m;
					}
			}
		}
		Arrays.sort(num1);
		if(num1[0]>0){
			System.out.print(num[0]);
		}else{
			System.out.print(0);
		}

	}

}
