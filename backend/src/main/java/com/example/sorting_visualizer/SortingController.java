package com.example.sorting_visualizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for React frontend
public class SortingController {

    @Autowired
    private SortingService sortingService;

    @PostMapping
    public ResponseEntity<SortingResponse> sortArray(@RequestBody SortingRequest request) {
        SortingResponse response = sortingService.sort(request);
        return ResponseEntity.ok(response);
    }
}