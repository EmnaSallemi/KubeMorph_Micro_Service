package com.example.service;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class PodService implements PodSer{
    


    @Override
    public List<V1Pod> getAllPods() throws FileNotFoundException, IOException, ApiException {

        String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
        ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
        Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();

        V1PodList podList = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
        
        return podList.getItems();
    }
    
}
