package 字节;

public class SingletonII
{
   //静态内部类实现
   private SingletonII() {
	   
   }
   
   private static class SingletonHolder{
	  private static final SingletonII INSTANCE = new SingletonII();
   }
   
   public static SingletonII getUniqueInstance() {
	return SingletonHolder.INSTANCE;	   
   }
   
}
