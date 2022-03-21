package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

	LifeBoard board;
	int mode = 0;

	public void keyPressed() 
	{
		if (keyCode == '0')
		{	
			mode = 0;
		}
		if (keyCode == '1')
		{	
			mode = 1;
		}
		if (keyCode == '2')
		{
			mode = 2;
		}
		if (keyCode == '3')
		{
			mode = 3;
		}
		if (keyCode == ' ')
		{
			mode = 9;
		}

		println(mode);
	}

	public void mouseDragged()
	{
		//int col =(int) (mouseX / (board.cellSize));

		int col = (int) map(mouseX, 0, width, 0, board.size);
		int row = (int) map(mouseY, 0, width, 0, board.size);

		board.setAlive(row, col, true);
	}

	public void settings() 
	{
		size(500, 500);
		board = new LifeBoard(200, this);
		board.randomise();
	}

	public void setup() {
		colorMode(RGB);
	}

	public void draw() 
	{	
		switch (mode)
		{
			//continue game
			case 0:
			{
				board.render();
				board.update();
			}
			break;

			//pause game
			case 9:
			{
				board.render();
			}
			break;

			//randomize board again
			case 1:
			{
				board.randomise();
				mode = 0;
			} 
			break;

			//clear board
			case 2:
			{
				int size = 500;

				for(int row = 0; row < size; row++)
				{
					for(int col = 0; col < size; col++)
					{
						board.setAlive(row, col, false);
					}
				}
				board.render();
			}
			break;

			case 3:
			{
				for(int row = 0; row < height; row++)
				{
					for(int col = height/2; col < width; col++)
					{
						board.setAlive(row, col, true);
					}
				}
				mode = 0;
			}
			break;
		}
	}
}
