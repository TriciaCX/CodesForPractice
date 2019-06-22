package 算法;

public class printAllSub
{
    public static void main(String[] args) {
    	String string="abc";
    	printAllSub(string,"",0);
    	
    }

 	private static void printAllSub(String string,String res,int index){
        if(index==string.length()) {
        	System.out.println(res);
        	return;
        }
        printAllSub(string,res+string.charAt(index),index+1);
        printAllSub(string,res,index+1);
	}

}
