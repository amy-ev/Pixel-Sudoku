package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class End extends JFrame {

    public End() {
        super.setBackground(Color.BLACK);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("would you like to play again?");

        JButton yesButton = new JButton("Yes");

        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeFrames();
                Main main = new Main();
            }
        });
        JButton noButton = new JButton("No");
        noButton.addActionListener(e -> System.exit(0));


        panel.add(label);
        panel.add(yesButton);
        panel.add(noButton);


        super.add(panel);
        super.setVisible(true);
        super.pack();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void removeFrames(){
        Frame[] currentFrames = Frame.getFrames();
        for (Frame currentFrame : currentFrames) {
            currentFrame.dispose();
        }
    }

}
