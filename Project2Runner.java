import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Project2Runner {

    public static void main(String[] args) {
        final String[] name = new String[1];

        JFrame frame = new JFrame("Seme4 Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setResizable(false);

        // Creating the different JPanels for the different Screens that will be displayed
        StartScreen start = new StartScreen();

        List<QsScreen> questions = new ArrayList<>();
        int[] scores = {0,0,0,0};
        int currentInd[] = {0};
        questions.add(new QsScreen("Pick a colour:", new String[] {"RED", "WHITE", "BLUE", "PURPLE"}, "1", scores));
        questions.add(new QsScreen("<html><div align='center'>How would your friends<br>describe you?</div></html>", new String[] {"Smart", "Dumb", "Level-Headed", "Weird/Strange"}, "2", scores));
        questions.add(new QsScreen("<html><div align='center'>Which character would you <br>be in a Fantasy World?</div></html>", new String[] {"Police Officer", "Vampire", "Rich Ceo", "Handsome Prince"}, "3", scores));
        questions.add(new QsScreen("<html><div align=center'>How do you act around<br>new people?</div></html>", new String[] {"Comedian", "Shy/Awkward", "Casual", "Talkative"}, "4", scores));
        questions.add(new QsScreen("How do you dress?", new String[] {"Fashionable/Trendy", "Casual/Comfort", "Brand Names", "Suits"}, "5", scores));
        questions.add(new QsScreen("<html><div align=center'>What genre of games<br>do you prefer?</div></html>", new String[] {"FPS Games", "CO-OP Games", "Cozy Games", "Story Games"}, "6", scores));
        questions.add(new QsScreen("Which would you eat?", new String[] {"Super Spicy Foods", "Meals with Rice", "Strawberry Snacks", "Seafood"}, "7", scores));

        WarnScreen warning = new WarnScreen();

        // Logic on how to change into the needed screen
        JTextField textField = new JTextField();
        textField.setBounds(225, 330, 250, 50);
        textField.setFont(new Font("Arial", Font.ITALIC, 20));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("Enter your name to start");
        textField.addActionListener(e -> {
            name[0] = textField.getText();
            frame.setContentPane(questions.get(currentInd[0]));
            frame.revalidate();
            frame.repaint();
        });
        warning.add(textField);

        
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                frame.setContentPane(warning);
                frame.revalidate();
                frame.repaint();

                // highlights the text box so users can type right away
                SwingUtilities.invokeLater(() -> {
                    textField.requestFocusInWindow();
                    textField.selectAll();
                });
            }
        });

        // Start of the Quiz, starts by displaying the start screen
        frame.setContentPane(start);
        // The different quiz questions will be displayed by looping through the list of them
        for (int i = 0; i < questions.size(); i++) {
            int index = i;
            questions.get(i).setNextScreen(() -> {
                currentInd[0] = index + 1;
                if (currentInd[0] < questions.size()) {
                    frame.setContentPane(questions.get(currentInd[0]));
                    frame.revalidate();
                    frame.repaint();
                }else { // When there are no more questions to go through, the end screen will be chosen and displayed
                    int count = 0;
                    int max = 0;
                    int ind = 0;
                    for (int c : scores) {if (c == 2) {count ++;}}

                    if (count > 2) {
                        // creates to the unique option, where the user has a personlity that isnt similar to any of the members
                        ind = 4;
                    }else{
                        for (int a = 0; a <= 3; a++) {
                            if (scores[a] > max) {
                                max = scores[a];
                                ind = a;
                            }
                        }
                    }
                    showEndScreen(ind, frame, name[0]);
                }    
            });
        }
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Helper method to make the end screen
    private static void showEndScreen(int ind, JFrame frame, String name) {
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        if (name.toLowerCase().equals("enter your name to start")) {name = "";}
        else {name = " " + name;}
        String[] names = {"LAUREN IROAS", "KUZUHA", "IBRAHIM", "FUWA MINATO", "NEITHER"};
        String[] icons = {"rrnIcon.png", "kzhIcon.png", "ibuIcon.png", "fuwIcon.png", "seme4Icon.png"};
        String[] desc = {
            "<html><div align='center'>Congratulations" + name + "! You are most like Lauren. You LOVE spicy foods like nobody else, and your energy is always at the max whenever you're with others. Additionally, like Lauren, you play a ton of FPS games, but humble about how good you are." + "</div></html>",
            "<html><div align='center'>Congratulations" + name + "! You are most like Kuzuha. You're kind of introverted when meeting new people, but when you get to know them you end up talking a lot. You spend a lot of your time with your close friends, but overall, prioritize your personal time" + "</div></html>",
            "<html><div align='center'>Congratulations" + name + "! You are most like Ibrahim. You are kind and relaxed, but also the one whos most oftenly getting teased by your friends. You love buying and wearing branded clothes and have a casual air of elegance and, well, wealthiness." + "</div></html>",
            "<html><div align='center'>Congratulations" + name + "! You are most like Fuwa.  You're silly and weird, always saying random things out of nowhere that makes no sense. This tends to drive your friends crazy but on the bright side, at least youre funny! You also love hosting events for your friends." + "</div></html>",
            "<html><div align='center'>Congratulations" + name + "! You are mostly unique and unlike any of the specific Seme4 members. Your personality is special and can't be described in terms of any of them as you share common things between each member, you could even say that you're similar to all of them!" + "</div></html>"
        };
        ImageIcon img = new ImageIcon(icons[ind]);
        ImageIcon scaledImg = new ImageIcon(img.getImage().getScaledInstance(350,220, Image.SCALE_SMOOTH));
        EndScreen end = new EndScreen(names[ind], scaledImg, desc[ind]);
        frame.setContentPane(end);
        frame.revalidate();
        frame.repaint();
    }
}
