package q3;



public abstract class searchabstract 
{
	
	public static void main(String[] args)
	{
		
		System.out.println("test");
	}
	public abstract boolean search(Object [] obj_list, Object obj);

}
class StringSearch extends searchabstract
{
	@Override
	public boolean search(Object[] obj_list, Object obj) 
	{
		for (int i = 0; i < obj_list.length; ++i)
		{
			if (((String)obj_list[i]).equals( ((String)obj))) {//typecasting
				System.out.println("found String at position"+i);
				return true;
				}
		}
		return false;
	}
}
class IntegerSearch extends searchabstract
{
	@Override
	public boolean search(Object[] obj_list, Object obj) 
	{
		for (int i = 0; i < obj_list.length; ++i)
		{
			if (((Integer)obj_list[i]) == ((Integer)obj)) {//typecasting
				System.out.println("found integer at position"+i);
				return true;
				}
		}
		return false;
	}
}
