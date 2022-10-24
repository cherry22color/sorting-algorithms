package sortingAlgorithms;

import sortingAlgorithms.Rendering.SortFrame;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class Main {


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                SortFrame ex = new SortFrame();
                ex.setVisible(true);
            }
        });
    }
}
