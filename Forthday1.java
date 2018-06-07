package 蓝桥杯;

import java.util.HashSet;
import java.util.Set;

public class Forthday1 {
	//给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

	//不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	public  static void main(String[] arg){
		int[] nums={1,3,5,3,7,1,4};
		int len=nums.length;
		Set set=new HashSet();
		for(int i=0;i<nums.length;i++){
			set.add(nums[i]);
		}
		System.out.println(set);
	}
	   

	public static int removeDuplicates(int[] nums) {  
        if(nums==null||nums.length==0){  
            return 0;  
        }  
        int j=0;  
        for(int i=0;i<nums.length;i++){  
            if(nums[i]!=nums[j]){  
                nums[++j]=nums[i];  
            }  
        }  
          
      return j;  
    }  
		
	}


