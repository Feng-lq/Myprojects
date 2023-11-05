package com.houseRent.utils;

import java.util.*;

public class Utility {
    private static Scanner sc = new Scanner(System.in);

    public static char readMenuSelection() {
        char c = ' ';
        while (true) {
            String str = readKeyBoard(1,false);
            c = str.charAt(0);
            if( c != '1' && c != '2' && c != '3'
                    && c != '4' && c != '5') {
                System.out.print("输入错误，请重新输入：");
            }else break;
        }
        return c;
    }

    public static char readChar() {
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }

    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1,true);
        return (str.isEmpty())
                ? defaultValue : str.charAt(0);
    }


    public static int readInt() {
        int n = 0;
        for ( ; ; ) {
            String str = readKeyBoard(10,false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }

        }
        return n;
    }

    public static int readInt (int defaultValue) {
        int n = 0;
        for ( ; ; ) {
            String str = readKeyBoard(10,true);

            if (str.isEmpty()){
                return defaultValue;
            }
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }

        }
        return n;
    }

    public static String readString(int lim) {
        return readKeyBoard(lim,false);
    }

    public static String readString(int lim,String defaultValue) {
        String str = readKeyBoard(lim,true);
        return str.isEmpty() ? defaultValue : str;
    }

    public static char readConfirmSelection() {
        System.out.println("请输入你的选择(y/n):");
        char c;
        for( ; ; ) {
            String str = readKeyBoard
                    (1,false).toLowerCase();
            c = str.charAt(0);
            if (c == 'y' || c =='n') {
                break;
            } else {
                System.out.print("选择错误，请重新选择：");
            }
        }
        return c;
    }

    public static String readKeyBoard(int lim,Boolean blankReturn) {
        String input = "";

        while(sc.hasNextLine()){
            input = sc.nextLine();

            if(input.isEmpty()) {
                if (blankReturn) return input;
                else continue;
            }

            if (input.length() < 1 || input.length() > lim) {
                System.out.println("输入长度不能大于" + lim +
                        "请重新输入：");
                continue;
            }
            break;
        }

        return input;

    }



}
