package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet
{
    Player p;
    Player p2;

    public void setup()
    {
        p = new Player(250, 100, 50, this);
        p2 = new Player(250, 100, 50, this);
    }

    public void settings()
    {
        size(500, 500);
    }

    public void draw()
    {
        background(0);
        p.update();
        p.render();

        p2.update();
        p2.render();
    }    
}
