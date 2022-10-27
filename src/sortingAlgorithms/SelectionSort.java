package sortingAlgorithms;

import java.util.Arrays;

public class SelectionSort implements ISortingAlgorithm {



    // проходим по массиву
    // находим минимальный элемент, ставим его на место первого в выбранной части массива
    // повторять до конца массива

    @Override
    public void sort(int[] numbers) {
        int size =  numbers.length;
        int indexMin; // переменная для хранения индекса мин элемента

        for (int index = 0; index < size - 1; index++) {
            indexMin =  index; //  считаем что первый элемент минимален
            for (int indexScan = index; indexScan < size; indexScan++) {
                // index  исключает рассматрение отсортированного массива
                if (numbers[indexMin] > numbers[indexScan]) {
                    indexMin = indexScan; // нашли индекс минимального элемента
                }
            }
            int buffer = numbers[index];
            numbers[index] = numbers[indexMin];
            numbers[indexMin] = buffer;
        }
    }
}
