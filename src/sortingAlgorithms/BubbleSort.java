package sortingAlgorithms;

import sortingAlgorithms.Rendering.SortFrame;

public class BubbleSort implements ISortingAlgorithm {



    @Override
    public void sort(int[] numbers) {
        boolean needIteration = true;
        int size = numbers.length;
         do{
            // итерируем до тех пор, пока не решим что необходимо закончить
            needIteration = false;
            for (int i = 1; i < size; i++) {
                // 1 < 1 для исключения массивв в 1 элемен
                if (numbers[i] < numbers[i - 1]) {
                    swap(numbers, i, i - 1);
                    needIteration = true;
                }
            }
        } while (needIteration);
    }


    public void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
