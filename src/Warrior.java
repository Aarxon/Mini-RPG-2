public class Warrior extends Player
{
    public Warrior(String name, String className, int health, int level, int experience)
    {
        super(name, className, health, level, experience);
    }

    public int attack()
    {
        return dealDmg();
    }
}
