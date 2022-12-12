package com.dimdof.math;

public class GeneratorStr {
    public char[] charset;
    public int charsetLength;

    public GeneratorStr(char[] charset){
        this.charset = charset;
        this.charsetLength = charset.length;
    }

    public String next(String init) {
        char[] initArr = init.toCharArray();
        int initLength = init.length() - 1;
        for (int i = initLength; i >= 0; i--) {
            for (int j = 0; j < charsetLength; j++) {
                if (initArr[i] == charset[j]) {
                    if (j == charsetLength-1){
                        initArr[i] = charset[0];
                    } else {
                        initArr[i] = charset[j + 1];
                        return new StringBuilder().append(initArr).toString();
                    }
                }
            }
        }
        return new StringBuilder().append(charset[1]).append(initArr).toString();
    }
}
