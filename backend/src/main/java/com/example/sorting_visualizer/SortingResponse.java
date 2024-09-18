package com.example.sorting_visualizer;

public class SortingResponse {
    private int[] sortedDataset;
    private long timeTaken;

    public SortingResponse(int[] sortedDataset, long timeTaken) {
        this.sortedDataset = sortedDataset;
        this.timeTaken = timeTaken;
    }

    public int[] getSortedDataset() {
        return sortedDataset;
    }

    public long getTimeTaken() {
        return timeTaken;
    }
}
