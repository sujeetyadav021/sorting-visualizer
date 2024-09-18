package com.example.sorting_visualizer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    // Bubble Sort
    public List<List<Integer>> bubbleSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        int n = array.size();
        boolean swapped;
        steps.add(new ArrayList<>(array)); // initial state

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    // Swap
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                    steps.add(new ArrayList<>(array)); // capture this step
                    swapped = true;
                }
            }
            if (!swapped) break; // if no elements were swapped, the array is sorted
        }
        return steps;
    }

    // Selection Sort
    public List<List<Integer>> selectionSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        int n = array.size();
        steps.add(new ArrayList<>(array)); // initial state

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array.get(j) < array.get(minIdx)) {
                    minIdx = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array.get(minIdx);
            array.set(minIdx, array.get(i));
            array.set(i, temp);
            steps.add(new ArrayList<>(array)); // capture this step
        }
        return steps;
    }

    // Insertion Sort
    public List<List<Integer>> insertionSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        steps.add(new ArrayList<>(array)); // initial state

        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;

            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                steps.add(new ArrayList<>(array)); // capture this step
                j = j - 1;
            }
            array.set(j + 1, key);
            steps.add(new ArrayList<>(array)); // capture this step
        }
        return steps;
    }

    // Merge Sort (Helper method)
    private void merge(List<Integer> array, int left, int mid, int right, List<List<Integer>> steps) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Integer> leftArray = new ArrayList<>(array.subList(left, mid + 1));
        List<Integer> rightArray = new ArrayList<>(array.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                array.set(k, leftArray.get(i));
                i++;
            } else {
                array.set(k, rightArray.get(j));
                j++;
            }
            k++;
            steps.add(new ArrayList<>(array)); // capture this step
        }

        while (i < n1) {
            array.set(k, leftArray.get(i));
            i++;
            k++;
            steps.add(new ArrayList<>(array)); // capture this step
        }

        while (j < n2) {
            array.set(k, rightArray.get(j));
            j++;
            k++;
            steps.add(new ArrayList<>(array)); // capture this step
        }
    }

    // Merge Sort (Main method)
    public List<List<Integer>> mergeSort(List<Integer> array, int left, int right, List<List<Integer>> steps) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid, steps);
            mergeSort(array, mid + 1, right, steps);

            merge(array, left, mid, right, steps);
        }
        return steps;
    }

    public List<List<Integer>> mergeSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        steps.add(new ArrayList<>(array)); // initial state
        return mergeSort(array, 0, array.size() - 1, steps);
    }

    // Quick Sort (Helper method)
    private int partition(List<Integer> array, int low, int high, List<List<Integer>> steps) {
        int pivot = array.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array.get(j) < pivot) {
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                steps.add(new ArrayList<>(array)); // capture this step
            }
        }
        int temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);
        steps.add(new ArrayList<>(array)); // capture this step
        return i + 1;
    }

    // Quick Sort
    public List<List<Integer>> quickSort(List<Integer> array, int low, int high, List<List<Integer>> steps) {
        if (low < high) {
            int pi = partition(array, low, high, steps);

            quickSort(array, low, pi - 1, steps);
            quickSort(array, pi + 1, high, steps);
        }
        return steps;
    }

    public List<List<Integer>> quickSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        steps.add(new ArrayList<>(array)); // initial state
        return quickSort(array, 0, array.size() - 1, steps);
    }

    // Heap Sort (Helper method)
    private void heapify(List<Integer> array, int n, int i, List<List<Integer>> steps) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array.get(left) > array.get(largest)) {
            largest = left;
        }

        if (right < n && array.get(right) > array.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int swap = array.get(i);
            array.set(i, array.get(largest));
            array.set(largest, swap);
            steps.add(new ArrayList<>(array)); // capture this step

            heapify(array, n, largest, steps);
        }
    }

    // Heap Sort
    public List<List<Integer>> heapSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        int n = array.size();
        steps.add(new ArrayList<>(array)); // initial state

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, steps);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array.get(0);
            array.set(0, array.get(i));
            array.set(i, temp);
            steps.add(new ArrayList<>(array)); // capture this step

            heapify(array, i, 0, steps);
        }
        return steps;
    }

    // Shell Sort
    public List<List<Integer>> shellSort(List<Integer> array) {
        List<List<Integer>> steps = new ArrayList<>();
        int n = array.size();
        steps.add(new ArrayList<>(array)); // initial state

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array.get(i);
                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                    steps.add(new ArrayList<>(array)); // capture this step
                }
                array.set(j, temp);
                steps.add(new ArrayList<>(array)); // capture this step
            }
        }
        return steps;
    }
}