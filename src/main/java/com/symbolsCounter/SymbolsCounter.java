package com.symbolsCounter;

import com.text_components.Symbol;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolsCounter {
    private Hashtable<Symbol, Integer> hashtable;

    public SymbolsCounter(List<Symbol> symbolList){
        hashtable = new Hashtable<>();
        countSymbols(symbolList);
    }

    private void countSymbols(List<Symbol> symbolList){
        for (Symbol symbol: symbolList){
            if (symbol.equals(" ")){
                continue;
            }

            if (hashtable.containsKey(symbol)){
                hashtable.replace(symbol, hashtable.get(symbol) + 1);
                continue;
            }

            hashtable.put(symbol, 1);
        }
    }

    public List<String> getSymbolsByItsCountInText(int count){
        List<Symbol> symbolsSortedByItsCount = getSymbolsSortedByItsCount();

        List<String> symbolsWithCount = new ArrayList<>();

        for (int i = 0; i < count; i++){
            Symbol symbol = symbolsSortedByItsCount.get(i);
            String symbolAndCount = symbol + " count: " + hashtable.get(symbol);

            symbolsWithCount.add(symbolAndCount);
        }

        return symbolsWithCount;
    }

    private List<Symbol> getSymbolsSortedByItsCount(){
        return hashtable.keySet()
                .stream()
                .sorted((symbol1, symbol2) -> Integer.compare(- hashtable.get(symbol1), - hashtable.get(symbol2)))
                .collect(Collectors.toList());
    }
}
