import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI
{
        private JFrame frame;
        private Player Aaron;
        private Enemies Outlaw;
        private JLabel playerHealthLabel;
        private JLabel OutlawHealthLabel;
        private JLabel PlayerXPLabel;

        public GUI(Player Aaron, Enemies Outlaw)
        {
            this.Aaron = Aaron;
            this.Outlaw = Outlaw;

            //Frame
            frame = new JFrame("Mini Game 2");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(720, 800);
            frame.setLocation(625, 90);
            frame.setResizable(false);
            frame.setLayout(null);

            //Player Health Bar
            playerHealthLabel = new JLabel("" + Aaron.getHealth());
            JPanel PlayerHealth = createHealthPanel(Aaron.getName(),playerHealthLabel, 0, 0, 250, 35);
            PlayerHealth.add(playerHealthLabel);

            //Player Experience Bar --------------------------------------------------------------
            PlayerXPLabel = new JLabel("" + Aaron.getXP() + "/" + "100");
            JPanel PlayerXP = createXPPanel(PlayerXPLabel, 0, 35, 250, 20);
            PlayerXP.add(PlayerXPLabel);
            //------------------------------------------------------------------------------------

            //OutLaw Health
            OutlawHealthLabel = new JLabel("" + Outlaw.getHealth());
            JPanel OutlawHealth = createHealthPanel(Outlaw.getName(),OutlawHealthLabel, 455, 0, 250, 35);
            OutlawHealth.add(OutlawHealthLabel);

            //Attack Button
            JButton attackButton = new JButton("Attack");
            attackButton.setBounds(300, 300, 100, 50);

            attackButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int damageDealt = Aaron.attack();
                    Outlaw.setHealth(Outlaw.getHealth()-damageDealt);
                    updateOutlawHealth();

                    if(Outlaw.getHealth() <= 0)
                    {
                        Aaron.setXP(Aaron.getXP()+100);
                        updateXP();
                        EnemeyDead();
                        attackButton.setEnabled(false);
                    }
                }
            }
            );

            //Inventory Button
            JButton viewInventory = new JButton("Inventory");
            viewInventory.setBounds(300, 350, 100, 50);

            //Finishing additions
            frame.add(PlayerHealth);
            frame.add(OutlawHealth);
            frame.setVisible(true);
            frame.add(attackButton);
            frame.add(viewInventory);
            frame.add(PlayerXP);
        }

        //Methods

    //Method to create health for reuse
    private JPanel createHealthPanel(String title, JLabel label, int x, int y, int width, int height)
    {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.red);
        panel.add(label);
        return panel;
    }
    private JPanel createXPPanel(JLabel label, int x, int y, int width, int height)
    {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.lightGray);
        panel.add(label);
        return panel;
    }

    //Method to create a message
    private JPanel createMessagePanel(JLabel label, int x, int y, int width, int height)
    {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setBackground(Color.white);
        panel.add(label);
        return panel;
    }

    //Method to display a message when you kill an enemey
    private void EnemeyDead()
    {
        JLabel deadMessageLabel = new JLabel("You slayed the outlaw! ");
        JPanel deadMessage = createMessagePanel (deadMessageLabel, 300, 30, 150, 50);
        frame.add(deadMessage);
    }

    //Setters
    public void updatePlayerHealth()
    {
            playerHealthLabel.setText("" + Aaron.getHealth());
            if(Aaron.getHealth() <= 0)
            {
                playerHealthLabel.setText("" + 0);
            }
    }
    public void updateOutlawHealth()
    {
        OutlawHealthLabel.setText("" + Outlaw.getHealth());

            if(Outlaw.getHealth() <= 0)
            {
                OutlawHealthLabel.setText("" + 0);
            }
    }

    public void updateXP()
    {
        PlayerXPLabel.setText("" + Aaron.getXP() + "/" + "100");
    }

}
