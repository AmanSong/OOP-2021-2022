package ie.tudublin;

public class Player 
{
    float x, y;
    float w;
    float halfW;

    YASC yasc;

    float rotation;

    public Player(float x, float y, float w, YASC yasc)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        halfW = w / 2.0f;
        this.yasc = yasc;
        this.rotation = 0;
    }

    void render()
    {
        yasc.rotate(rotation);
        float halfW = w / 2;
        yasc.stroke(255);
        yasc.line(x - halfW, y + halfW, x, y - halfW);
        yasc.line(x, y - halfW, x + halfW, y + halfW);
        yasc.line(x + halfW, y + halfW, x, y);
        yasc.line(x, y, x - halfW, y + halfW);
    }

    public void update()
    {
        if(yasc.keyPressed)
        {
            if(yasc.key == 'w')
            {
                y--;
            }
            if(yasc.key == 's')
            {
                y++;
            }
            if(yasc.key == 'a')
            {
                rotation -= 0.01f;
            }
            if(yasc.key == 'd')
            {
                rotation += 0.01f;
            }
        }
    }

}
