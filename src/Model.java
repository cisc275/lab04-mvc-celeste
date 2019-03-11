
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

public class Model{
	int frameWidth,frameHeight,imgWidth,imgHeight;
	int xloc = 0;
	int yloc = 0;
	Direction direction;
	int xIncr = 8;
	int yIncr = 2;
	    
	Model(int fw, int fh, int iw, int ih){
		this.frameWidth = fw;
		this.frameHeight = fh;
		this.imgWidth = iw;
		this.imgHeight = ih;
		this.direction = Direction.SOUTHEAST;
	}

	//called to update, and determine the location and Direction of the model, and calculate collision with boundaries
	public void updateLocationAndDirection(){
		xloc += xIncr;
		yloc += yIncr;
		if(xloc + imgWidth >= frameWidth)
    	{
    		xIncr = -xIncr;
    		if(yIncr > 0) 
    		{
    			direction = Direction.SOUTHWEST;
    		}
    		if(yIncr < 0) 
    		{
    			direction = Direction.NORTHWEST;
    		}
    	}
		if(yloc + imgHeight >= frameHeight - 10)
    	{
    		yIncr = -yIncr;
    		if(xIncr > 0) 
    		{
    			direction = Direction.NORTHEAST;
    		}
    		if(xIncr < 0) 
    		{
    			direction = Direction.NORTHWEST;
    		}
    	}
		if(xloc <= -30)
    	{
    		xIncr = -xIncr;
    		if(yIncr > 0) 
    		{
    			direction = Direction.SOUTHEAST;
    		}
    		if(yIncr < 0) 
    		{
    			direction = Direction.NORTHEAST;
    		}
    	}
		if(yloc <= -15)
    	{
    		yIncr = -yIncr;
    		if(xIncr > 0) 
    		{
    			direction = Direction.SOUTHEAST;
    		}
    		if(xIncr < 0) 
    		{
    			direction = Direction.SOUTHWEST;
    		}
    	}
	}
	
	public int getX() {
		return this.xloc;
	}
	public int getY() {
		return this.yloc;
	}

	public Direction getDirect(){
		return this.direction;
	}
}