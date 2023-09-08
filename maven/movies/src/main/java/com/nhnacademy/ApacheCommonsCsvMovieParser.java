package com.nhnacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCsvMovieParser implements MovieParser {
    @Override
    public List<Movie> parse(String fileName) throws IOException {
        CSVParser parser = CSVParser.parse(new InputStreamReader(getMovieFileAsStream()), CSVFormat.EXCEL);
        Set<String> set = new HashSet<>();
        List<Movie> movieList = new ArrayList<>();

        for (CSVRecord csvRecord : parser) {
            long movieId = Integer.parseInt(csvRecord.get(0));
            String movieName = csvRecord.get(1);
            String[] genres = csvRecord.get(2).split("|");
            for (String s : genres) {
                set.add(s);
            }

            movieList.add(new Movie(movieId, movieName, set));
        }
        
        return movieList;
    }

}