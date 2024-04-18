package com.example.controller;

import com.example.service.PodService;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Pod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;




@RestController
@RequestMapping("/api/pods")
public class PodController {
 
    @Autowired
    private  PodService podService;

    
     @GetMapping("/list")
    public ResponseEntity<List<V1Pod>> listPods() throws FileNotFoundException, IOException, ApiException {
        List<V1Pod> pods = podService.getAllPods();
        return new ResponseEntity<>(pods, HttpStatus.OK);   
    }
}
