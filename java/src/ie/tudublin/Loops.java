package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{
	float cx;
	float cy;

	public void settings()
	{
		size(500, 500);
		cx = width / 2;
		cy = height /2;
	}

	public void setup() 
	{
		colorMode(HSB);
		
	}

	public void draw()
	{	
		background(0);
		noStroke();

		if (mouseX < cx && mouseY < cy)
		{
			rect(0, 0, cx, cy);
		}
		else if (mouseX > cx && mouseY < cy)
		{
			rect(cx, 0, cx, cy);
		}
		else if (mouseX < cx && mouseY > cy)
		{
			rect(0, cy, cx, cy);
		}
		else
		{
			rect(cx, cy, cx, cy);
		}
	}
}
