import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("PremKatha");
        frame.setSize(500,100);

        JLabel label = new JLabel("JISNE BHI YE VALENTINE_DAY MANANE KI NIYAM BANAYA NA HUM SINGALO KI HAAY LAGEGI USS KO");
        label.setFont(new Font("Arial",Font.BOLD,30));
        //frame.add(label);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String [] words = label.getText().split(" ");
        final int[] currentWordIndex = {0};

        JLabel currentWordLabel = new JLabel(words[currentWordIndex[0]]);
        currentWordLabel.setFont(new Font("Arial",Font.BOLD,30));

        currentWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(currentWordLabel,BorderLayout.CENTER);

        frame.validate();

        final int[] xpos = {10};
        final int[] direction = {1};
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentWordIndex[0] =(currentWordIndex[0]+1)%words.length;
                currentWordLabel.setText(words[currentWordIndex[0]]);

                currentWordLabel.setLocation(xpos[0],50);
                currentWordLabel.repaint();

                xpos[0] += currentWordLabel.getWidth()* direction[0];

                if(xpos[0] >frame.getWidth()-currentWordLabel.getWidth()|| xpos[0] <0){
                    direction[0] =-direction[0];
                }
            }
        });
        timer.start();


    }
}