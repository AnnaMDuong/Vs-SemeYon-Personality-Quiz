import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartScreen extends JPanel{
    public StartScreen() {
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);

        JLabel personalityQuiz = new JLabel("- Personality Quiz -");
        personalityQuiz.setFont(new Font("Arial", Font.PLAIN, 20));
        personalityQuiz.setBounds(0,10,700,20);
        personalityQuiz.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel title = new JLabel("<html><div align='center'>Which Seme4 Member<br>are YOU?</div></html>");
        title.setFont(new Font("Arial", Font.BOLD,40));
        title.setBounds(0,40,700,90);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon seme4 = new ImageIcon(getClass().getResource("seme4c.png"));
        // w = 435
        ImageIcon scaledIcon = new ImageIcon(seme4.getImage().getScaledInstance(520, 295, Image.SCALE_SMOOTH));
        JLabel seme4Img = new JLabel(scaledIcon);
        seme4Img.setBounds(0,140,700,295);
        seme4Img.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel pressKey = new JLabel("Press anywhere to continue");
        pressKey.setFont(new Font("Arial", Font.PLAIN,20));
        pressKey.setBounds(0,440,700,25);
        pressKey.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(personalityQuiz);
        this.add(title);
        this.add(pressKey);
        this.add(seme4Img);
    }
}
