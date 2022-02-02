package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 1;
    float playerY = 2;
    float playerWidth = 3;


    public void settings()
    {
        size(400, 400);
    }

    public void setup()
    {

    }

    public void draw()
    {
        drawPlayer(5, 5, 5);
    }

    public void drawPlayer(float x, float y, float width)
    {
        strokeWeight(1);
        stroke(1, 10,10);

        playerX = x;
        playerY = y;
        playerWidth = width;
    }
}
