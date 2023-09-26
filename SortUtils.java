package ru.geekbrains.lesson2;

public class SortUtils {

    //Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
    public static void piramidalSort(int[]array) {
        for(int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        for(int i = array.length - 1; i >= 0; i--){
             int temp = array[0];
             array[0] = array[i];
             array[i] = temp;

             heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array [rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array, heapSize, largest);
        }
    }


    /**
     * Сортировка выбором
     * @param array массив
     */
    public static void directSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if (min != i){
                int buf = array[i];
                array[i] = array[min];
                array[min] = buf;
            }
        }
    }


    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array
     * @param start
     * @param end
     */
    private static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;

        int middle = array[(start + end) / 2]; // Значение опорного элемента

        do {
            while (array[left] < middle){
                left++;
            }

            while (array[right] > middle){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int buf = array[left];
                    array[left] = array[right];
                    array[right] = buf;
                }
                left++;
                right--;
            }
        }
        while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }

        if (start < right){
            quickSort(array, start, right);
        }
    }
}











