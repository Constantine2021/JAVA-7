package com.reader;

import java.io.*;

public class TextReader {
    private String path = "/Users/kosta/IdeaProjects/"+
                            "Lab7/src/main/resources/file.txt";
    private BufferedReader bufferedReader;

    public TextReader(){
        File file = new File(path);
        try{
            bufferedReader = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException e){
            System.out.println("File wasn't found");
        }
    }

    public String readText() {
        StringBuilder text = new StringBuilder();
        try{
            String line;
            while((line = bufferedReader.readLine()) != null){
                text.append(line);
            }
        }
        catch (IOException e){
            System.out.println(e.toString());
        }

        return text.toString();
    }
}
