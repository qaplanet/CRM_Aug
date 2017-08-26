import java.util.ArrayList;
import java.util.Iterator;

public class EX 
{
	public static void main(String[] args)
	{
		ArrayList<String> AL=new ArrayList<String>();
		AL.add("qap1");
		AL.add("qap2");
		AL.add("qap1");
		
		for(String A: AL)
		{
			System.out.println(A);
		}
		
	}
}
