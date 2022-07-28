package com.example.demo.csv;

import com.example.demo.exception.BetriebsstelleNotFoundException;
import com.example.demo.model.Betriebsstelle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class DBService {

    private static final String filePath = "src/main/java/com/example/demo/csv/db.csv";

    @Bean
    public List<Betriebsstelle> readCSV(){

        List<Betriebsstelle> list = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

            list = br.lines().skip(1).
                    map(itemDB).
                    collect(Collectors.toList());

        } catch (IOException e) {
                e.printStackTrace();
        }
        return list;
    }


    private Function<String, Betriebsstelle> itemDB = (line) -> {

        String[] str = line.split(";");

        if(str.length < 4) {
            throw new BetriebsstelleNotFoundException(line);
        }else {
            return new Betriebsstelle(str[2], str[3], str[5], str[1]);
        }
    };
}
