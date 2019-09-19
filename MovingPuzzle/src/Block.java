import java.awt.Point;

public class Block
	{
		private Point pos;
		private String value;
		
		public Block(Point p, String s)
		{
			pos = new Point(p);
			value = s;
		}
		public Block(int x, int y, String s)
		{
			pos = new Point(x, y);
			value = s;
		}
		
		
	}
