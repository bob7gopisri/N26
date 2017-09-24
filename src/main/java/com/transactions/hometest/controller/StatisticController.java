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

@Controller
public class StatisticController {

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< Statistic > statisticsResponse() {

        // Statistic singleton instance will already have the updated stats, return the same. This is O(1) complexity
        ResponseEntity<Statistic> responseEntity = new ResponseEntity<>(Statistic.getInstance(), HttpStatus.OK);
        return responseEntity;
    }
}