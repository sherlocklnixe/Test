package 蓝桥杯;

import java.util.Arrays;

public class Secday1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] num={-1,-2,-3,0,1,2,3};
        for(int i=0;i<num.length;i++){
        	for(int j=i+1;j<num.length;j++){
        		for(int k=j+1;k<num.length;k++){
        			if(num[i]+num[j]+num[k]==0){
        				int[] num1={num[i],num[j],num[k]};
        				System.out.println(Arrays.toString(num1));
        			}
        			}
        		}
        }
	}

}
