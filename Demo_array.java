

class Demo_array {

	public static void main(String[] args) {
		
		System.out.println(uniquePaths1(7,3));
		
	}
	public static int  uniquePaths1(int m, int n) {  
        int total = m + n -2; //һ��Ҫ�ߵĲ���  
        int down = m - 1;  //����Ҫ�ߵĲ���  
        double res = 1;  
        for(int i = 1 ; i <= down; i++){  
            res =res * (total - down + i) / i;  
        }  
        return (int)res;  
    }  

}
