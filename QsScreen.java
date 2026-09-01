import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
// Put in text here to overlay the buttons
public class QsScreen extends JPanel{
    private String question;
    private String[] options;
    private String qsNum;
    private int[] scores;
    private Runnable nextScreen;

    public QsScreen(String question,String[] options,String qsNum, int[] scores) {
        this.question = question;
        this.options = options;
        this.qsNum = qsNum;
        this.scores = scores;

        this.setLayout(null);
        this.setBackground(Color.PINK);

        Box b1 = new Box(options[0], () -> {
            scores[0] ++;
            if (nextScreen != null) nextScreen.run();
        }); 
        Box b2 = new Box(options[1], () -> {
            scores[1] ++;
            if (nextScreen != null) nextScreen.run();
        }); 
        Box b3 = new Box(options[2], () -> {
            scores[2] ++;
            if (nextScreen != null) nextScreen.run();
        }); 
        Box b4 = new Box(options[3], () -> {
            scores[3] ++;
            if (nextScreen != null) nextScreen.run();
        }); 

        b1.setBounds(20,190,320,120);
        b2.setBounds(360,190,320,120);
        b3.setBounds(20,330,320,120);
        b4.setBounds(360,330,320,120);

        // displays questions 
        
        JLabel qsText = new JLabel(question);
        qsText.setBounds(0,50, 700, 100);
        qsText.setHorizontalAlignment(SwingConstants.CENTER); // horizontally centers the text
        qsText.setFont(new Font("Arial", Font.BOLD,40));

        JLabel numText = new JLabel("Question " + qsNum + " out of 7");
        numText.setBounds(0,5, 700, 40);
        numText.setHorizontalAlignment(SwingConstants.CENTER); // horizontally centers the text
        numText.setFont(new Font("Arial", Font.BOLD,20));

        // adds the boxes to the pannels
        this.add(qsText);
        this.add(numText);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
    }

    public void setNextScreen(Runnable nextScreen) {
        this.nextScreen = nextScreen;
    }
}