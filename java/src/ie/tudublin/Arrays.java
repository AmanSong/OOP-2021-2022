package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet{

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    //new object array with 100 elements allocated
    float[] array1 = new float[100];

    //new array but no elements allocated
    float[] array2;

    float min = rainfall[0];
    float max = rainfall[0];
    int maxIndex;
    int mode = 0;

    public void settings()
    {
        size(500, 500);
    }

    public void keyPressed()
	{
		if (key >= '0' && key <='9')
		{
			mode = key - '0';
		}
		println(mode);
	}

    public void setup()
    {
        for(int i = 0; i < rainfall.length; i++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        /*
        enhanced for loop
        for(float r:rainfall)
        {
            println(r);
        }
        */

        for(int i = rainfall.length-1; i >= 0; i--)
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        float totalRain = 0;
        float averageRain = 0;

        for(int i = 0; i < rainfall.length; i++)
        {
            if(min > rainfall[i])
            {
                min = rainfall[i];
            }
            if(max < rainfall[i])
            {
                max = rainfall[i];
                maxIndex = i;
            }

            totalRain = totalRain + rainfall[i];
        }
        averageRain = totalRain / rainfall.length;
        println(min, "is the lowest");
        println(max, "is the highest");
        println(totalRain, "is the total amount of rainfall");
        println(averageRain, "is the average yearly rainfall");
    }

    public void draw()
    {   
        switch(mode)
        {
            case 0:
            {
                background(0);
                colorMode(HSB);
                float w = width / (float)rainfall.length;
                noStroke();
                for (int i = 0 ; i < rainfall.length ; i++)
                {
                    float x = map(i, 0, rainfall.length, 0, width);
                    int c = (int)map(i, 0, rainfall.length, 0, 255);

                    fill(c, 255, 255);

                    float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);

                    rect(x, height, w, h);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (w / 2), height - 10);
                }
                break;
            }
            case 1:
            {
            //BAR CHART
                background(0);
                float border = width * 0.1f;
                // draw the aixis
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                for(int i = 0; i <= 120; i++)
                {
                    float y = map(i, 0, 120, height-border, border);
                    line(border-5, y, border, y);
                    fill(255);
                    textAlign(CENTER,CENTER);
                    text(i, (border/2), y);
                }
                float w = (width-(border*2.0f)) / (float)rainfall.length;
                for(int i = 0; i < rainfall.length; i++)
                {
                    float x = map(i, 0, rainfall.length, border, width-border);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -height + (border*2));
                    rect(x, height-border, w, h);
                    fill(255);
                    text(months[i], x+ (w/2), height-(border/2));
                    textAlign(CENTER,CENTER);
                }
                break;
            }

            case 2:
            //PIE CHART
                background(0);
                float r = width * 0.3f;
                float cx = width / 2;
                float cy = height / 2;
                noFill();
                stroke(255);
                circle(cx, cy, r * 2.0f);
                float total = 0;
                for(int i = 0; i < rainfall.length; i++)
                {
                    total = total + rainfall[i];
                }
                float start = 0;
                for(int i = 0; i <rainfall.length; i++)
                {
                    float val = map(rainfall[i], 0, total, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    stroke(255);
                    fill(c, 255, 255);
                    arc(cx, cy, r * 2,r * 2, start, start + val, PIE);

                    float theta = start + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    text(months[i], x, y);

                    start = start + val;
                }
        }
    }
}
