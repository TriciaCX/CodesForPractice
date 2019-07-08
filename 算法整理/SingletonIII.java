package 字节;

public enum SingletonIII
{
	INSTANCE;

	private String objName;

	public String getObjName()
	{
		return objName;
	}

	public void setObjName(String objName)
	{
		this.objName = objName;
	}

    public static void main(String[] args) {
    	// 单例测试
    	SingletonIII firstSingleton = SingletonIII.INSTANCE;
    	firstSingleton.setObjName("firstName");
    	System.out.println(firstSingleton.getObjName());
    	SingletonIII secondSingleton = SingletonIII.INSTANCE;
    	secondSingleton.setObjName("secondName");
    	System.out.println(firstSingleton.getObjName());
    	System.out.println(secondSingleton.getObjName());
    	// 反射获取实例测试
    	try {
    		SingletonIII[] enumConstants = SingletonIII.class.getEnumConstants();
    		for (SingletonIII enumConstant : enumConstants) {
    			System.out.println(enumConstant.getObjName());
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
   
}
