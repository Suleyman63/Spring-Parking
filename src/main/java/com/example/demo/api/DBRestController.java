package com.example.demo.api;


import com.example.demo.csv.DBService;
import com.example.demo.exception.BetriebsstelleNotFoundException;
import com.example.demo.model.Betriebsstelle;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class DBRestController {

    private final DBService dbService;

    public DBRestController(DBService dbService) {
        this.dbService = dbService;
    }

    @GetMapping(value = "/betribsstelle/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Stream<Betriebsstelle> readCSV(@PathVariable("code") String code) {

        List<Betriebsstelle> betriebsstelleList = dbService.readCSV();

        if(betriebsstelleList.isEmpty()) {
            throw new BetriebsstelleNotFoundException(code);
        }
        else return betriebsstelleList.stream().filter(t->t.getCode().equalsIgnoreCase(code));

    }
}
