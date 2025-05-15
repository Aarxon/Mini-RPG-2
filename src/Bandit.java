public class Bandit extends Enemies
{
    public Bandit(String name, int health, int level)
    {
        super(name, health, level);
    }

    public int attack()
    {
       return dealDmg();
    }

}
