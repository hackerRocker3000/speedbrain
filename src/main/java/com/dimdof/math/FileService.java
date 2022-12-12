package com.dimdof.math;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static void writeBase(String filename, String[] data) {
        try {
            Arrays.sort(data);
            BufferedWriter outputWriter = null;
            outputWriter = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < data.length; i++) {
                outputWriter.write(data[i]);
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
