package q2;

public abstract class Quadilateral {
	private Integer height = null;
	private Integer base = null;
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Quadilateral(Integer height,Integer base) {
		// TODO Auto-generated method stub
		this.height = height;
		this.base = base;

	}
	public abstract void area();

	public class Square extends  Quadilateral{
		public Integer area(Integer side)
		{ 
			return side * side; 
		}
		
		public Square(Integer height, Integer base)
		{ super(base, height); }

		
		public void area() {
			// TODO Auto-generated method stub
			return ; 

		}

	}
	public class Rectangle extends  Quadilateral{
		public Integer area(Integer base,Integer height)
		{ 
			return base * height; 
		}
		
		public Rectangle(Integer height, Integer base)
		{ super(base, height); }

		
		public void area() {
			// TODO Auto-generated method stub
			return ; 

		}
	}
	public class Parellelogram extends  Quadilateral{
		public Integer area(Integer base,Integer height)
		{ 
			return base * height; 
		}
		
		public Parellelogram(Integer height, Integer base)
		{ super(base, height); }

		
		public void area() {
			// TODO Auto-generated method stub
			return ; 

		}
	}
	public class Square2 extends Rectangle{
		public Integer area(Integer side)
		{ 
			return side * side; 
		}
		
		public Square2(Integer height, Integer base)
		{ super(base, base); }

		
		public void area() {
			// TODO Auto-generated method stub
			return ; 

		}
	}

}
