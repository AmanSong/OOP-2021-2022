package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet{

    float[] rainfall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    //new object array with 100 elements allocated
    float[] array1 = new float[100];

    //new array but no elements allocated
    float[] array2;

    public void settings()
    {
        size(500, 500);
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

        float min = rainfall[0];
        float max = rainfall[0];
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
        background(0);
        colorMode(HSB);
        float w = width / (float)rainfall.length;

        for(int i = 0; i < rainfall.length; i++)
        {
            float x= i*w;
            noStroke();
            int c = (int)map(i, 0, rainfall.length, 0, 255);
            fill(c, 255, 255);
            rect(x, height, w, -rainfall[i]);
            textAlign(CENTER,CENTER);
            fill(0);
            text(months[i], x + (w/2), height-10);
        }
    }
}
