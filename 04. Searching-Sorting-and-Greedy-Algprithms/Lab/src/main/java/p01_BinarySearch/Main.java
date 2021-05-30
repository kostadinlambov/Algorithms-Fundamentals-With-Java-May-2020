package p01_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementToFind = Integer.parseInt(reader.readLine());

        int index = binarySearch(numbers, elementToFind, 0, numbers.length -1);

        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] < key)
                start = mid + 1;
            else if (arr[mid] > key)
                end = mid - 1;
            else
                return mid;
        }

        return -1;
    }

    private static int findIndex(int[] numbers, int elementToFind, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int midIndex = (endIndex - startIndex) / 2;

        if (numbers[midIndex] > elementToFind) {
            endIndex = midIndex - 1;
            return findIndex(numbers, elementToFind, startIndex, endIndex);
        } else if (numbers[midIndex] < elementToFind) {
            startIndex = midIndex +1;
            return findIndex(numbers, elementToFind, startIndex, endIndex);
        }

        return midIndex;
    }



}
