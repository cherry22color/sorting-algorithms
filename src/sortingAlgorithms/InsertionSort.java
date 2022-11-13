package sortingAlgorithms;

public class InsertionSort implements ISortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        // final long start = System.nanoTime();
        // пройти по массиву
        //выбрать последовательно элемент
        // установить элемент на законное место
        long start = System.nanoTime();

        int sizeAre = numbers.length - 1;
        int currentElement; // текущий элемент
        int indexToInsert; // переменная обозначаяющая индекс в отсортированой части массива
        for (int index = 0; index <= sizeAre; index++) {
            currentElement = numbers[index];
            indexToInsert = index; // обозначает индекс для вставки
            while (indexToInsert > 0 && numbers[indexToInsert - 1] > currentElement) {
                //пока индекс для вставки > 0  пока не просмотрели все элементы не отсортированного массива
                // и пока значение под текущим индексом больше  элементов в отсортированной чсти массива
                numbers[indexToInsert] = numbers[indexToInsert - 1];
                indexToInsert--;
                numbers[indexToInsert] = currentElement;
            }
        }
        final long stop = System.nanoTime();
        System.out.println(stop - start);
    }
}
