package ie.tudublin;

public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private int lives;
    public int numlives()
    {
        return lives;
    }

    public void kill(int newlives)
    {
        lives = newlives;

        while(lives > 0)
        {
            if(lives > 0)
            {
                lives -= 1;
                System.out.println("Ouch!");
            }
        }

        if(lives == 0)
        {
            System.out.println("Dead!");
        }
    }
}

class newcat
{
    public static void main(String[] args)
    {
        Cat ginger = new Cat("Ginger");

        ginger.kill(9);
    }
}