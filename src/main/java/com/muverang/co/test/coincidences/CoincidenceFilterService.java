package com.muverang.co.test.coincidences;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CoincidenceFilterService {

    public List<Map.Entry<String, Integer>> readWords() throws IOException {
        File file = new File("src/main/resources/static/el_quijote.txt");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader streamReader = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(streamReader);

        Map<String, Integer> map = new HashMap<>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = Arrays.stream(line.split("[!¡¿?.,:;()'\"]+"))
                    .collect(Collectors.joining(" ")).split("\\s+");
            for (String w: words) {
                String word = w.toLowerCase();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> top10 = new ArrayList<>(map.entrySet())
            .stream()
            .sorted(((e1, e2) -> e2.getValue().compareTo(e1.getValue())))
            .limit(10)
            .collect(Collectors.toList());

        return top10;
    }
}
