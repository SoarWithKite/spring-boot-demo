package com.zhiyuan;

/**
 * @author Kite
 */

public class ReplaceCharacters {


    public static void main(String[] args) {
        String input = "444121321326121321326121321326";
        String result = replaceCharacters(input);
        System.out.println(result);
    }

    public static String replaceCharacters(String input) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '1':
                    output.append('1');
                    break;
                case '2':
                    output.append('4');
                    break;
                case '3':
                    output.append('3');
                    break;
                case '4':
                    output.append('2');
                    break;
                default:
                    output.append(c);
                    break;
            }
        }
        return output.toString();
    }
}
