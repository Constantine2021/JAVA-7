import com.reader.TextReader;
import com.symbolsCounter.SymbolsCounter;
import com.textparser.TextParser;

/*
В тексте найти и напечатать n символов (и их количество), встречающихся
наиболее часто.
 */

public class Main {
    public static void main(String[] args) {
        TextParser textParser = new TextParser(new TextReader().readText());
        textParser.parseText();

        SymbolsCounter symbolsCounter = new SymbolsCounter(textParser.getSymbolList());

        System.out.println(symbolsCounter.getSymbolsByItsCountInText(3));
    }
}
