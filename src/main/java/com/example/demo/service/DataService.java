package com.example.demo.service;

import com.example.demo.H2.entites.ApiDatah;
import com.example.demo.H2.repo.H2Repository;
import com.example.demo.MySQL.repo.MySQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@EnableScheduling
@Service
public class DataService {

    private final String apiUrl = "http://localhost:8081/v1/versionControl/checkForUpdate";

    @Autowired
    private H2Repository h2Repository;

    @Autowired
    private MySQLRepository mySQLRepository;

    WebClient webClient = WebClient.create();

    @Scheduled(fixedDelay = 9000000)
    public void test(){
        fetchDataAndSaveToH2();
        transferDataFromH2ToMySQL();
    }

    public void fetchDataAndSaveToH2() {
        List<ApiDatah> apiDataList = webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToFlux(ApiDatah.class)
                .collectList()
                .block();

        if (apiDataList != null) {
            h2Repository.saveAll(apiDataList);
        }
    }

    public void transferDataFromH2ToMySQL() {
        List<ApiDatah> apiDataList = h2Repository.findAll();
        for (ApiDatah api: apiDataList  ) {
            System.out.println(api.getProduct());
            System.out.println(api.getVersion());
        }
//        if (apiDataList != null) {
//            mySQLRepository.saveAll(apiDataList);
//        }
    }
}