package sortingAlgorithms;

import sortingAlgorithms.Rendering.SortFrame;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Main {


    public static void main(String[] args) {

//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//                SortFrame ex = new SortFrame();
//                ex.setVisible(true);
//            }
//        });

        int[] unSortedArray = {2, 1, 4, 8, 7, 5, 6, 3};
        ISortingAlgorithm selectSort = new SelectionSort();
        selectSort.sort(unSortedArray);
        System.out.println(Arrays.toString(unSortedArray));

    }
}
