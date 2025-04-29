package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabel extends JLabel {
    Timer timer;
    final int[] countSecs = {0};

    public TimerLabel() {
        super.setText("00:00");


        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countSecs[0]++;

                int minutes = countSecs[0] / 60;
                int seconds = countSecs[0] % 60;
                String timerText = String.format("%02d:%02d", minutes, seconds);
                TimerLabel.super.setText(timerText);
            }
        });
        timer.start();
    }

    public void resetCountSecs() {
        countSecs[0] = 0;
        getTimer().restart();
        super.setText("00:00");
    }
    public Timer getTimer() {
        return timer;
    }

    public String stopTimer(){
        timer.stop();
        return super.getText();
    }
}
