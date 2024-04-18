package com.example.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.models.V1Pod;

public interface PodSer {
    public List<V1Pod> getAllPods() throws FileNotFoundException, IOException, ApiException;

}
