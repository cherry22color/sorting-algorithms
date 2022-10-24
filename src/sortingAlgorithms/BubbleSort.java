package sortingAlgorithms;

import sortingAlgorithms.Rendering.SortFrame;

public class BubbleSort implements ISortingAlgorithm {

    public BubbleSort()
    {
    }


    @Override
    public void sort(int[] numbers) {
        boolean needIteration = true;
        while (needIteration) {
            // итерируем до тех пор, пока не решим что необходимо закончить
            needIteration = false;
            for (int i = 1; i < numbers.length; i++) {
                // 1 < 1 для исключения массивв в 1 элемен
                if (numbers[i] < numbers[i - 1]) {
                    swap(numbers, i, i - 1);
                    needIteration = true;
                }
            }
        }
    }


    public void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
