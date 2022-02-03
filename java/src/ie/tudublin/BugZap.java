package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 250;
    float playerY = 450;
    float playerWidth = 10;

    float bugX = 100;
    float bugY = 20;
    float bugWidth = 10;

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        colorMode(RGB);
        smooth();
        background(0);
    }

    public void draw()
    {
        background(0);
        drawPlayer(playerX, playerY, playerWidth);
        drawBug(bugX, bugY, bugWidth);

        //bug movements
        if ((frameCount % 60) == 0)
        {   
            float randX = random(-50, 50);

            bugX = bugX + randX;
            bugY = bugY + 5;

            if (bugX <= 0)
            {
                bugX = bugX + randX;
                return;
            }
            else if (bugX >= 500)
            {
                bugX = bugX - randX;
                return;
            }
        }
    }

    public void drawPlayer(float x, float y, float width)
    {
        strokeWeight(5);
        stroke(255, 255, 255);

        float height = width / 2;

        line(x, y, width + x, height + y);
    }

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            playerX =  playerX - 10;

            if (playerX <= 0)
            {
                playerX = playerX + 10;
                return;
            }

			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
            playerX = playerX + 10;

            if (playerX >= 500)
            {
                playerX = playerX - 10;
                return;
            }

			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
            line(playerX, playerY - 500, playerWidth + playerX, height + playerY);
			System.out.println("SPACE key pressed");
		}
	}	

    public void drawBug(float x, float y, float width)
    {
        strokeWeight(4);
        stroke(255, 255, 255);

        float height = width / 2;

        line(x, y, width + x, height + y);
    }

}
