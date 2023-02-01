package ru.nsu.fit.biryukovSergey.WordsAnalyzer;

import java.io.*;
import java.nio.CharBuffer;
import java.util.*;

public class WordsAnalyzer {
    private final String fileName;
    private final TreeMap<String, Integer> wordMap = new TreeMap<>();
    private int wordCount;
    public WordsAnalyzer(String fileName) {
        this.wordCount = 0;
        this.fileName = fileName;
    }
    private void OnWordScan(String word) {
        wordCount++;
        if(wordMap.containsKey(word)) {
            wordMap.replace(word, wordMap.get(word)+1);
        } else {
            wordMap.put(word, 1);
        }
    }
    public void OutputMap(String fileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        List<Map.Entry<String, Integer>> sorted = new LinkedList<>(wordMap.entrySet());
        Collections.sort(sorted, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));
        for(Map.Entry<String, Integer> item : sorted) {
            StringBuilder line = new StringBuilder();
            line.append(item.getKey()).append(",")
                    .append(item.getValue()).append(",")
                    .append(String.format( Locale.US,"%.2f",(float)item.getValue()/wordCount)).append("\n");
            writer.write(line.toString());
        }
        writer.close();
    }
    public void Analyze() throws IOException{
        Scanner scanner = new Scanner(new File(fileName));
        while(scanner.hasNext()) {
            String scanned = scanner.next();
            if(!scanned.isEmpty()) {
                OnWordScan(scanned);
            }
        }
    }
}