package com.nhnacademy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BasicMovieParser implements MovieParser {
    List <Movie> movieList = new ArrayList<>();
    String line;
    long id;
    String title;
    Set<String> genres = new HashSet();
    
    @Override
    public List<Movie> parse(String fileName) throws IOException {
        Movie movie = new Movie(id, fileName, genres);
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/movies.csv"));
            reader.readLine();

        while ((line = reader.readLine()) != null) {
            if (line.contains("\".*([0-9]+)\"")){
                String[] lines = line.split("\"");
                movie.setMovieId(Integer.parseInt(lines[0].replaceAll(", ", "")));
                movie.setTitle(lines[1]);
                String[] genre = lines[2].replaceAll(", ", "").split("\\|");
                for (String g:genre) {
                    genres.add(g);
                }
                movie.setGenres(genres);
            } 
            else {
                String lines[] = line.split(",");
                movie.setMovieId(Integer.parseInt(lines[0]));
                movie.setTitle(lines[1]);;
                String[] genre = lines[2].split("\\|");
                for (int i=0; i<genre.length; i++) {
                    genres.add(genre[i]);
                }
                movie.setGenres(genres);
            }
            movieList.add(movie);
        }
    } catch (Exception e) {
        // TODO: handle exception
        System.out.println("excention : "+e);
    }
    
    return movieList;
}

}
/* String[] gen = line.split("\\|");
for (int i=2; i<gen.length; i++) {
    genres.add(gen[i]);
}

String[] lines = line.split(",");
genres.add(lines[lines.length]);

long id = Integer.parseInt(lines[0]);
String title="";

for (int i=1; i<lines.length; i++){
    title = title +lines[i];
}

Movie movie = new Movie(id, title, genres);
movieList.add(movie); */