package CIS210M;

import java.util.Timer;
import java.util.TimerTask;

public class timer {
    int secondspast = 0;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            secondspast++;
        }
    };
public void runtimer(){
    timer.scheduleAtFixedRate(task,1000,1000);
}
}
