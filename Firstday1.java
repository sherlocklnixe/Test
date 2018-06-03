package 蓝桥杯;

import java.util.Arrays;

public class Firstday1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		for(int i=0;i<4;i++){
			for(int j=i+1;j<4;j++){
				int num[]={2,4,6,8};
				int n=12;
				if(num[i]+num[j]==n){
					int num2[]={i,j};
					System.out.println(Arrays.toString(num2));;
					}
			}
		}
		
		
	}

}
