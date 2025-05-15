import java.util.Random;

public abstract class Enemies
{
    Random randDmg = new Random();

    private String name;
    private int health;
    private int level;
    private int weaponDmg;


    public Enemies(String name, int health, int level)
    {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    //Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setHealth(int health)
    {
        this.health = health;

        if(health < 0)
        {
            health = 0;
        }
    }

    public void setWeaponDmg(int weaponDmg)
    {
        this.weaponDmg = weaponDmg;
    }

    //Inheritors
    public abstract int attack();

    //Methods
    public void levelUp()
    {
        setName(name + " Level 2");
        level++;

        //Health Logic
        health += 20 * (level);
    }

    public int dealDmg()
    {
        int randomDamage = randDmg.nextInt(10 * level); ;
        return (level * 2) + randomDamage;
    }

    //Getters
    public String getName()
    {
        return name;
    }

    public int getHealth()
    {
        return health;
    }
}
