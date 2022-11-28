package com.dimdof.math;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static String[] readBase(String path) {

        List<String> listOfStrings
                = new ArrayList<String>();

        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String line = bf.readLine();
            while (line != null) {
                listOfStrings.add(line);
                line = bf.readLine();
            }
            bf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfStrings.toArray(new String[0]);
    }
}
