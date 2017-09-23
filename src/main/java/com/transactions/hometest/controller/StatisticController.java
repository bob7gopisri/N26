package com.transactions.hometest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.transactions.hometest.model.Statistic;
import com.transactions.hometest.service.StatisticService;

@Controller
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< Statistic > statisticsResponse() {

        Statistic statistics = statisticService.getStatistics();
        ResponseEntity<Statistic> responseEntity = new ResponseEntity<>(statistics, HttpStatus.OK);
        return responseEntity;
    }
}