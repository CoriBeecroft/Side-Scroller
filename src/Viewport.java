
public class Viewport 
{
	private Rectangle outerRectangle;
	private Rectangle innerRectangle;
	private Character character;
	private Driver driver;
	
	public Viewport(Rectangle rectangle, Character character, Driver driver)
	{
		this.outerRectangle = rectangle;
		this.character = character;
		this.driver = driver;
		this.innerRectangle = new Rectangle((int)(rectangle.getXPosition() + 0.1*rectangle.getWidth()), (int)(rectangle.getYPosition() + 0.1*rectangle.getHeight()), (int)(rectangle.getWidth()*0.8), (int)(rectangle.getHeight()*0.8));
	}
	
	public void update()
	{
		if(driver.leftPressed)
		{
			if(character.getLeftX() <= innerRectangle.getLeftX())
			{
				if(!(character.getLeftX() < Driver.LEFT_BOUNDARY))
				{
				moveOuter(Character.LEFT);
				}
				
				if(getLeftX() < Driver.LEFT_BOUNDARY)
				{
					setLeftX(Driver.LEFT_BOUNDARY);
				}
				else
				{
					moveInner(Character.LEFT);
				}
			}
		}
		
		if(driver.rightPressed)
		{
			if(character.getRightX() >= getInnerRectangle().getRightX())
			{
				if(!(character.getRightX() > Driver.RIGHT_BOUNDARY))
				{
					moveOuter(Character.RIGHT);
				}
				
				if(getRightX() > Driver.RIGHT_BOUNDARY)
				{
					setRightX(Driver.RIGHT_BOUNDARY);
				}
				else
				{
					moveInner(Character.RIGHT);
				}
			}
		}
		
		if(driver.upPressed)
		{
			if(character.getTopY() <= getInnerRectangle().getTopY())
			{
				if(!(character.getTopY() < Driver.TOP_BOUNDARY))
				{
					moveOuter(Character.UP);
				}
				
				if(getTopY() < Driver.TOP_BOUNDARY)
				{
					setTopY(Driver.TOP_BOUNDARY);
				}
				else
				{
					moveInner(Character.UP);
				}
			}
		}
		
		if(driver.downPressed)		//Make is so that if there is a collision the circle is moved up so that it sits just above the ground. 
		{
			if(character.getBottomY() >= innerRectangle.getBottomY())
			{
				if(!(character.getBottomY() > Driver.BOTTOM_BOUNDARY))
				{
					moveOuter(Character.DOWN);
				}
				
				if(getBottomY() > Driver.BOTTOM_BOUNDARY)
				{
					setBottomY(Driver.BOTTOM_BOUNDARY);
				}
				else
				{
					moveInner(Character.DOWN);
				}				
			}
		}

	}
	
	public Rectangle getInnerRectangle() 
	{
		return innerRectangle;
	}

	public void setInnerRectangle(Rectangle innerRectangle) 
	{
		this.innerRectangle = innerRectangle;
	}

	public void moveOuter(int direction)
	{
		switch (direction)
		{
		case 0:
			outerRectangle.incrementXPosition(-1*character.getSpeed());
			break;
		case 1:
			outerRectangle.incrementXPosition(1*character.getSpeed());
			break;
		case 2:
			outerRectangle.incrementYPosition(-1*character.getSpeed());
			break;
		case 3:
			outerRectangle.incrementYPosition(1*character.getSpeed());
			break;
		default:
			System.out.println("Invalid direction!");
		}
	}
	
	public void moveInner(int direction)
	{
		switch (direction)
		{
		case 0:
			innerRectangle.incrementXPosition(-1*character.getSpeed());
			break;
		case 1:
			innerRectangle.incrementXPosition(1*character.getSpeed());
			break;
		case 2:
			innerRectangle.incrementYPosition(-1*character.getSpeed());
			break;
		case 3:
			innerRectangle.incrementYPosition(1*character.getSpeed());
			break;
		default:
			System.out.println("Invalid direction!");
		}
	}
	
	//
	// Getters and Setters
	//
	
	
	public int getXPosition()
	{
		return outerRectangle.getXPosition();
	}
		
	public int getYPosition()
	{
		return outerRectangle.getYPosition();
	}
	
	public int getWidth()
	{
		return outerRectangle.getWidth();
	}
	
	public int getHeight()
	{
		return outerRectangle.getHeight();
	}
	
	public int getLeftX()
	{
		return outerRectangle.getXPosition();
	}

	public void setLeftX(int xPosition)
	{
		this.outerRectangle.setLeftX(xPosition);
	}
	
	public int getRightX()
	{
		return outerRectangle.getXPosition() + outerRectangle.getWidth();
	}
	
	public void setRightX(int rightX)
	{
		outerRectangle.setRightX(rightX);
	}
	
	public int getTopY()
	{
		return outerRectangle.getYPosition();
	}
	
	public void setTopY(int yPosition)
	{
		this.outerRectangle.setTopY(yPosition);
	}
	
	public int getBottomY()
	{
		return outerRectangle.getYPosition() + outerRectangle.getHeight();
	}
	
	public void setBottomY(int bottomY)
	{
		outerRectangle.setBottomY(bottomY);
	}
}