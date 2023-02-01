import ru.nsu.fit.biryukovSergey.WordsAnalyzer.WordsAnalyzer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            throw new RuntimeException("Usage: <program name> <input file name> <outputfilename>");
        }

        WordsAnalyzer analyzer = new WordsAnalyzer(args[0]);
        try {
            analyzer.Analyze();
            analyzer.OutputMap(args[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}