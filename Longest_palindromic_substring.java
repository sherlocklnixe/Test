package 蓝桥杯;

import java.util.Arrays;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。


 */


public class Longest_palindromic_substring {
	public static void main(String[] args) {
		Longest_palindromic_substring lpc=new Longest_palindromic_substring();
		char[] st2={'b','c','c','c','f'};
		boolean a=lpc.panduan(st2);
		System.out.println(a);
		//char[] arr1=str.toCharArray();
		//String st=st1.valueOf(arr1);
		//System.out.println(Arrays.toString(arr1));
		//System.out.println(st);
		String str="abcdcfgabcddcba";
		int len=0;
		String str1="";
		for(int i=0;i<str.length()-1;i++){
			for(int j=i+1;j<str.length();j++){
			String str2=str.substring(i,j+1);
			char[] arr=str2.toCharArray();
			//System.out.println(Arrays.toString(arr));
			if(lpc.panduan(arr)==true&&arr.length>len){
				//System.out.println(Arrays.toString(arr));
				len=arr.length;
				str1=str2;
			}
			}
			
			}
		System.out.println(str1);
		
		
	}
	//1234321
	public boolean  panduan(char[] arr){
		boolean a = true;
		for(int i=0;i<arr.length/2;i++){
			if(arr[i]==arr[arr.length-1-i]&&a==true){
				a=true;
			}else{
			a=false;
			}
		}
		return  a;
	}

}
