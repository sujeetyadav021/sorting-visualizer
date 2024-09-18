package com.example.sorting_visualizer;

import org.springframework.stereotype.Service;

@Service
public class SortingService {

    public SortingResponse sort(SortingRequest request) {
        int[] sortedArray;
        long startTime = System.nanoTime();

        switch (request.getAlgorithm()) {
            case "quick":
                sortedArray = SortingAlgorithm.quickSort(request.getDataset());
                break;
            case "merge":
                sortedArray = SortingAlgorithm.mergeSort(request.getDataset());
                break;
            default:
                throw new IllegalArgumentException("Invalid algorithm");
        }

        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;

        return new SortingResponse(sortedArray, timeTaken);
    }
}