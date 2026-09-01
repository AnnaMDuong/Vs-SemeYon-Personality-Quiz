import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EndScreen extends JPanel{
    private String winner;
    private ImageIcon winnerImg;
    private String winnerText;
    public EndScreen(String winner, ImageIcon winnerImg, String winnerText) {
        this.winnerImg = winnerImg;
        this.winner = winner;
        this.winnerText = winnerText;
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);

        // Creates the Confetti that appears
        JLabel gifLabel = new JLabel(new ImageIcon("confetti.gif"));
        gifLabel.setBounds(0, 0, 700, 500); // position it
        gifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gifLabel.setVerticalAlignment(SwingConstants.CENTER);

        // Creates the words at the top
        JLabel personality = new JLabel("You are: " + winner + "!!"); //pass the string as a variable in the main probably
        personality.setFont(new Font("Arial", Font.BOLD,40));
        personality.setBounds(0,10,700,40);
        personality.setHorizontalAlignment(SwingConstants.CENTER);

        // Creates the image
        JLabel img = new JLabel(winnerImg);
        img.setBounds(175,60,350,220);

        // Creates the description of the winner personalit
        JLabel desc = new JLabel(winnerText); // this will also be from main LOL
        desc.setFont(new Font("Arial", Font.PLAIN,20));
        desc.setBounds(25,300,650,100);

        // ADD A PERCENTAGE OF HOW MUCH OF EACH ONE THEY ARE - OR - ADD A LEAVE BUTTON
        JButton leaveButton = new JButton("Click to Exit");
        leaveButton.setFont(new Font("Arial", Font.BOLD, 15));
        leaveButton.setBounds(275,410,150,50);
        
        leaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(gifLabel);
        this.add(personality);
        this.add(img);
        this.add(desc);
        this.add(leaveButton);

    }
}
