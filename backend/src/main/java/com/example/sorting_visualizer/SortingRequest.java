package com.example.sorting_visualizer;

public class SortingRequest {
    private int[] dataset;
    private String algorithm;

    // Getters and Setters
    public int[] getDataset() {
        return dataset;
    }

    public void setDataset(int[] dataset) {
        this.dataset = dataset;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}