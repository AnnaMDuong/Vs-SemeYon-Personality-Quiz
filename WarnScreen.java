import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WarnScreen extends JPanel{
    public WarnScreen() {
        this.setLayout(null);
        this.setBackground(Color.PINK);
        String label = "<html><div align='center'><strong>!!DISCLAIMER!!</strong><br>Once you click your desired option, you CANNOT go back, so be sure you choose your options carefully and try not to misclick!<br><br>To proceed with the quiz,<br>enter your name below!</div></html>";

        JLabel disclaimer = new JLabel(label);
        disclaimer.setFont(new Font("Arial", Font.PLAIN, 30));
        disclaimer.setBounds(30,35,640,300);
        disclaimer.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(disclaimer);
    }
}
