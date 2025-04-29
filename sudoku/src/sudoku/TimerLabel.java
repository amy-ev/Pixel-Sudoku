package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabel extends JLabel {

    public TimerLabel() {
        super.setText("00:00");

        Timer timer = new Timer(1000, new ActionListener() {
            //int minutes = 0;
            int countSecs = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                countSecs++;

                int minutes = countSecs / 60;
                int seconds = countSecs % 60;
                String timerText = String.format("%02d:%02d", minutes, seconds);
                TimerLabel.super.setText(timerText);
            }
        });
        timer.start();
    }
}
