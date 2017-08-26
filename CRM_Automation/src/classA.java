public class classA
{
	//Type1: No arguments and no returns
	void method1()
	{
		System.out.println("Method1");
	}
	
	//Type 2: Only arguments
	void method2(int a,int b)
	{
		System.out.println(a+b);
	}
	
	//Type3: Only returns
	boolean method3()
	{
		return true;
	}
	
	//type4 : Arguments & returns
	int method4(int a,int b)
	{
		int c=a+b;
		return c;
	}
	
	public static void main(String[] args)
	{
		classA x=new classA();
		x.method1();
		x.method2(10, 20);
		boolean res=x.method3();
		System.out.println(res);
		int res1=x.method4(21325, 5454);
		System.out.println(res1);
	}
}
