package ���ű�;

import java.util.HashSet;
import java.util.Set;

public class Forthday1 {
	//����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�

	//��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

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


