import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Enemies Outlaw = new Bandit("Outlaw", 100, 1);
        Player Aaron = new Warrior("Aaron", "Warrior", 100, 1, 0);
        new GUI(Aaron, Outlaw);
    }
}
