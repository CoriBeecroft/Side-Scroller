import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class Structure 
{
	List<Point2D> top; 
	List<Point2D> bottom;
//	List<Point2D> left;		add these in 
//	List<Point2D> right;	later maybe
	Point2D startPoint;
	Point2D endPoint;
	
	
	public Structure(List<Point2D> top, List<Point2D> bottom)
	{
		this.top = top;
		this.bottom = bottom;
//		this.left = left;
//		this.right = right;		
	}
	
	public Structure(Function top, Function bottom, Point2D startPoint, Point2D endPoint)
	{
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.top = new ArrayList<Point2D>();
		this.bottom = new ArrayList<Point2D>();
		
		for(int x=(int)startPoint.getX(); x<endPoint.getX(); x++)
		{
			this.top.add(new Point2D.Double(x, top.call(x)));
		}
		
		for(int x = (int)startPoint.getX(); x<endPoint.getX(); x++)
		{
			this.bottom.add(new Point2D.Double(x, bottom.call(x)));
		}
	}

	
	
	//
	// Getters and Setters
	//
	
	public List<Point2D> getTop() 
	{
		return top;
	}

	public void setTop(List<Point2D> top) 
	{
		this.top = top;
	}

	public List<Point2D> getBottom() 
	{
		return bottom;
	}

	public void setBottom(List<Point2D> bottom) 
	{
		this.bottom = bottom;
	}

	public Point2D getStartPoint() 
	{
		return startPoint;
	}

	public void setStartPoint(Point2D startPoint) 
	{
		this.startPoint = startPoint;
	}

	public Point2D getEndPoint() 
	{
		return endPoint;
	}

	public void setEndPoint(Point2D endPoint) 
	{
		this.endPoint = endPoint;
	}
}
