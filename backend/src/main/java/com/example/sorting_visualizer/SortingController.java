package com.example.sorting_visualizer;

//import com.example.sorting_visualizer.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for frontend
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping
    public List<List<Integer>> sort(@RequestBody Map<String, Object> request) {
        // Extract the dataset and ensure type safety
        List<?> rawDataset = (List<?>) request.get("dataset");

        // Safely cast to List<Integer>
        List<Integer> dataset = new ArrayList<>();
        for (Object obj : rawDataset) {
            if (obj instanceof Integer) {
                dataset.add((Integer) obj);
            }
        }

        // Extract sorting algorithm
        String algorithm = (String) request.get("algorithm");

        List<List<Integer>> sortedSteps = null;

        // Use the selected algorithm
        switch (algorithm.toLowerCase()) {
            case "bubble":
                sortedSteps = sortingService.bubbleSort(dataset);
                break;
            case "selection":
                sortedSteps = sortingService.selectionSort(dataset);
                break;
            case "insertion":
                sortedSteps = sortingService.insertionSort(dataset);
                break;
            case "merge":
                sortedSteps = sortingService.mergeSort(dataset);
                break;
            case "quick":
                sortedSteps = sortingService.quickSort(dataset);
                break;
            case "heap":
                sortedSteps = sortingService.heapSort(dataset);
                break;
            case "shell":
                sortedSteps = sortingService.shellSort(dataset);
                break;
            default:
                throw new IllegalArgumentException("Invalid algorithm selected");
        }

        return sortedSteps;
    }
}