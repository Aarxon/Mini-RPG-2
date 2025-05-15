import java.util.Random;

public abstract class Player
{
    Random randDmg = new Random();

    private String name;
    private String className;
    private int level;
    private int health;
    private int experience;

    public Player(String name, String className, int health, int level, int experience)
    {
        this.name = name;
        this.level = level;
        this.health = health;
        this.className = className;
    }

    //Inheritors
    public abstract int attack();


    //Methods
    public void levelUp()
    {
        level++;

        //Health Logic
        health += 20 * (level);

        System.out.println("Congratulations! " + name + " You have leveled from level " + (level - 1)+ " to level " + level);
    }

    public int dealDmg()
    {
        int randomDamage = randDmg.nextInt(10 * level); ;
        return (level * 2) + randomDamage;
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;

    }

    public void setHealth(int health)
    {
        this.health = health;
    }
    public void setXP(int experience)
    {
        this.experience = experience;
    }

    //Getters
    public int getLevel()
    {
        return level;
    }

    public int getHealth()
    {
        return health;
    }

    public String getName()
    {
        return name;
    }

    public int getXP()
    {
        return experience;
    }
}
