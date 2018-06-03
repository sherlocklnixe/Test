package 蓝桥杯;

import java.util.Arrays;

public class Firstday2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int num1[]={1,3,5,7};
		int num2[]={2,4,6};
		float b;
		int num[]=zuhe(num1,num2);
		Arrays.sort(num);
		if(num.length%2==0){
			int a=num[num.length/2]+num[num.length/2+1];
			 b=a/2;
		}else{
			int c=num.length+1;
			 b=num[c/2];
		}
		
        System.out.println(b);
	}

	private static int[] zuhe(int[] num1, int[] num2) {
		// TODO 自动生成的方法存根
		int[] num=new int[num1.length+num2.length];
		for(int i=0;i<num.length;i++){
			if(i<num1.length){
				num[i]=num1[i];
			}else{
				num[i]=num2[i-num1.length];
			}
		}
		return num;
	}

}
