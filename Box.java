import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// ADD A METHOD TO SEE IF THE BOX HAS BEEN CLICKED OR NOT (use this boolean to add points to the options)

public class Box extends JPanel {
    private boolean isHovering = false;
    private Runnable onClick;
    private String option;
    
    public Box(String option, Runnable onClick) {
        this.option = option;
        this.onClick = onClick;
        setPreferredSize(new Dimension(320, 120));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovering = true;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                isHovering = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (onClick != null) {onClick.run();}
            }
            
        });
    }

    @Override
    public void paintComponent(Graphics g) { // you can now draw in here
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        if (isHovering) {g.setColor(Color.LIGHT_GRAY);}
        else {g.setColor(Color.WHITE);}
        g.fillRect(0, 0, 320, 120);
        
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLACK);
        //text size
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(option);
        int xLoc = (320/2) - (textWidth/2);
        g.drawString(option, xLoc, 70);
    }
}
