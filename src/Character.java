
public class Character 
{
	
	private int xPosition;
	private int yPosition;
	private int health;
	private int radius;	
	private int speed = 10;
	
	private Driver driver;
	
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	

	public Character(int xPosition, int yPosition, int health, int radius, Driver driver) //Maybe there is a better way to get a reference to the driver object 
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.health = health;
		this.radius = radius;
		this.driver = driver;
	}

	public void update()
	{
		boolean groundCollision = false;
		SineWave ground = new SineWave(500, 400, 100, 150);
		
		if((int)ground.call(getCenterX()) <= getBottomY())
		{
			groundCollision  = true;
		}
		
		if(driver.leftPressed)
		{
			move(Character.LEFT);
			if(getLeftX() < Driver.LEFT_BOUNDARY)
			{
				setLeftX(Driver.LEFT_BOUNDARY);
			}
		}
		
		if(driver.rightPressed)
		{
			move(Character.RIGHT);
			
			if(getRightX() > Driver.RIGHT_BOUNDARY)
			{
				setRightX(Driver.RIGHT_BOUNDARY);
			}
			
		}
		
		if(driver.upPressed)
		{
			move(Character.UP);

			if(getTopY() < Driver.TOP_BOUNDARY)
			{
				setTopY(Driver.TOP_BOUNDARY);
			}

		}
		
		if(driver.downPressed && !groundCollision)//Make is so that if there is a collision the circle is moved up so that it sits just above the ground. 
		{
			move(Character.DOWN);

			if(getBottomY() > Driver.BOTTOM_BOUNDARY)
			{
				setBottomY(Driver.BOTTOM_BOUNDARY);
			}
		}

	}
	
	public void move(int direction)
	{
		switch (direction)
		{
			case 0:
				xPosition -= speed;
				break;
			case 1:
				xPosition += speed;
				break;
			case 2:
				yPosition -= speed;
				break;
			case 3:
				yPosition += speed;
				break;
			default:
				System.out.println("Invalid direction!");
		}
	}
	
	//
	// Getters and Setters
	//
	
	public int getSpeed() 
	{
		return speed;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}

	public int getXPosition() 
	{
		return xPosition;
	}

	public int getYPosition() 
	{
		return yPosition;
	}

	public int getTopY()
	{
		return yPosition;
	}
	
	public void setTopY(int yPosition) 
	{
		this.yPosition = yPosition;
	}
	
	public int getBottomY()
	{
		return yPosition + 2*radius;
	}
	
	public void setBottomY(int bottomY)
	{
		yPosition = bottomY - 2*radius;
	}
	
	public int getLeftX()
	{
		return xPosition;
	}

	public void setLeftX(int xPosition) 
	{
		this.xPosition = xPosition;
	}

	public int getRightX()
	{
		return xPosition + 2*radius;
	}
	
	public void setRightX(int rightX)
	{
		xPosition = rightX - 2*radius;
	}
	
	public int getCenterX()
	{
		return xPosition + radius;
	}

	public void setCenterX()
	{
		System.out.println("setCenterX. IMPLEMENT ME!");
	}
	
	public int getCenterY()
	{
		return yPosition + radius;
	}

	public void setCenterY()
	{
		System.out.println("setCenterY. IMPLEMENT ME!");
	}
	
	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public int getRadius() 
	{
		return radius;
	}

	public void setRadius(int radius) 
	{
		this.radius = radius;
	}
}
