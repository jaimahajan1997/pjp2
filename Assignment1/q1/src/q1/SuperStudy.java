package q1;


public class SuperStudy 
{
	public void X()
	{ System.out.println("I am in SuperStudy.X()"); }

	public static void main(String[] args) 
	{ 
		SuperStudyChild ssc = new SuperStudyChild();
		ssc.X(); 
	}
}

class SuperStudyChild extends SuperStudy
{
	
	public void X()
	{ 
		super.X(); //Basically function name is same in child so to call parent method we need use super to call parent method othervise recursively it will run and stackiverflow error comes.
		System.out.println("I am in SuperStudyChild.X()"); 
	}
}
