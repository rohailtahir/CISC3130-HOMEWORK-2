// Name: Rohail Tahir
// Programming Language: Java
// IDE / Editor: JDoodle

/*
Homework 2 - Sorting and Searching Algorithms

Part 4 - Bubble Sort Big O

Question 1:
The worst-case time complexity of Bubble Sort is O(n^2).

Question 2:
Bubble Sort is O(n^2) because it goes through the array multiple times
and keeps comparing values next to each other. The nested loops cause
the number of comparisons to grow a lot as the array gets bigger.

Question 3:
With 10 elements, Bubble Sort could require about 45 comparisons,
while 1,000 elements could require about 499,500 comparisons in the
worst case. This big difference happens because Bubble Sort is O(n^2),
so the amount of work grows roughly with the square of the input size.


Part 6 - Compare Bubble Sort and Merge Sort

Question 4:
The time complexity of Merge Sort is O(n log n).

Question 5:
Merge Sort generally performs better when there is a large amount of
data. Its O(n log n) time complexity grows slower than Bubble Sort's
O(n^2), so it handles larger arrays more efficiently.

Question 6:
Bubble Sort = O(n^2)
Merge Sort = O(n log n)


Part 11 - Searching Questions

Question 7:
Linear Search has a time complexity of O(n). In the worst case, it
might have to check every element before finding the target or finding
out that the target is not in the array.

Question 8:
Binary Search has a time complexity of O(log n). It keeps cutting the
search area in half, so it usually has to check much fewer values than
Linear Search.

Question 9:
Binary Search needs sorted data because it uses the middle value to
decide which half of the array to search next. If the array was not
sorted, it would not know which side the target could be on.

Question 10:
I would use Linear Search if the data was not sorted. It checks each
value one at a time, so the values do not need to be in any specific
order.

Question 11:
I would use Binary Search for a very large sorted array. It is more
efficient because it removes half of the remaining search area after
each comparison.


Part 12 - Algorithm Comparison Table

Algorithm       Purpose       Big O
___________    _________     _______
Bubble Sort      Sorting       O(n^2)
Merge Sort      Sorting       O(n log n)
Linear Search   Searching     O(n)
Binary Search   Searching     O(log n)
*/

public class Main {

    public static void main(String[] args) {

        // Part 2 - Create the Data Set
        int[] originalArray = {
            42, 17, 85, 6, 73, 29, 54, 11, 96, 38, 67, 23
        };

        System.out.println("Original Array:");
        printArray(originalArray);


        // Part 3 - Bubble Sort
        int[] bubbleArray = originalArray.clone();
        bubbleSort(bubbleArray);

        System.out.println("\nBubble Sort Result:");
        printArray(bubbleArray);


        // Part 5 - Merge Sort
        int[] mergeArray = originalArray.clone();
        mergeSort(mergeArray, 0, mergeArray.length - 1);

        System.out.println("\nMerge Sort Result:");
        printArray(mergeArray);


        // Part 7 and 8 - Linear Search
        System.out.println("\nLinear Search");

        System.out.println("\nSearch 1:");
        runLinearSearch(originalArray, 17);

        System.out.println("\nSearch 2:");
        runLinearSearch(originalArray, 67);

        System.out.println("\nSearch 3:");
        runLinearSearch(originalArray, 500);


        // Part 9 and 10 - Binary Search
        System.out.println("\nBinary Search");

        System.out.println("\nSearch 1:");
        runBinarySearch(mergeArray, 11);

        System.out.println("\nSearch 2:");
        runBinarySearch(mergeArray, 85);

        System.out.println("\nSearch 3:");
        runBinarySearch(mergeArray, 500);
    }


    // Bubble Sort
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {

        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }


    public static void merge(int[] array, int left, int middle, int right) {

        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightArray[j] = array[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < leftSize) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    // Linear Search
    public static int linearSearch(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }


    public static void runLinearSearch(int[] array, int target) {

        int index = linearSearch(array, target);

        System.out.println("Target: " + target);

        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found.");
        }
    }


    // Binary Search
    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (array[middle] == target) {
                return middle;
            }

            if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }


    public static void runBinarySearch(int[] array, int target) {

        int index = binarySearch(array, target);

        System.out.println("Target: " + target);

        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found.");
        }
    }


    // Prints the array
    public static void printArray(int[] array) {

        for (int number : array) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
