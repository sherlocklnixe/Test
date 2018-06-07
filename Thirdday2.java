package 蓝桥杯;

import java.util.Arrays;

public class Thirdday2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//股票利益最大值，多次买卖同一只股票
		int[] num= {7,3,5,8,2,1};
		int sum=0;
		for(int i=1;i<6;i++){
			int b=num[i]-num[i-1];
			if(b>0){
				sum+=b;
			}
				}
			System.out.println(sum);

			}

		
		/*for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				int m=num[i]-num[j];
					for(int k=0;k<num1.length;k++){
						num1[k]=m;
						
					}
					System.out.println(num1[i]);
			}
		}
		System.out.println(Arrays.toString(num1));
		    Arrays.sort(num1);
			int n=num1[0]+num1[1];
			if(n>0){
                System.out.println(n);
			}else{
				System.out.println(0);
			}
			*/
	}


