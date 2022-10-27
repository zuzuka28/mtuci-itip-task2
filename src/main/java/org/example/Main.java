package org.example;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//      task 1
        System.out.println(repeat("mice", 5) );
        System.out.println(repeat("hello", 3) );
        System.out.println(repeat("stop", 1) );
//     task 2
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[] {44, 32, 86, 19}));
//      task 3
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));
        System.out.println(isAvgWhole(new int[]{1, 1, 1}));
        System.out.println(isAvgWhole(new int[]{9, 2, 2, 5}));
//      task 4
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
//      task 5
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));
//      task 6
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));
//      task 7
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));
//      task 8
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));
//      task 9
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
//      task 10
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
    }

    public static String repeat(String s, int n){
        String tmp = "";
        // проходим по всем символам и дублируем их n раз
        for (char i: s.toCharArray()){
            tmp += Character.toString(i).repeat(n);
        }
        return tmp;
    }

    public static int differenceMaxMin(int[] mas) {
        // преобразуем массив в stream, который поддерживает математические операции
        return Arrays.stream(mas).max().getAsInt() - Arrays.stream(mas).min().getAsInt();
    }

    public static boolean isAvgWhole(int[] mas) {
        //  если остаток 0 - целое, иначе - дробное
        return  Arrays.stream(mas).average().getAsDouble() % 1 == 0;
    }

    public static int[] cumulativeSum(int[] mas) {
        int[] tmp = new int[mas.length];
        // каждый элемент это сам элемент и сумма слайса элементов до
        for (int i = 0; i < mas.length; i ++){
            tmp[i] = (mas[i] + Arrays.stream(Arrays.copyOfRange(mas, 0, i)).sum());
        }

        return  tmp;
    }

    public static int getDecimalPlaces(String mas) {
        // разбиваем по точке на целую и дробную части. если есть дробная часть то пишем ее длинну
        String[] tmp = mas.split("[.]");
        if (tmp.length == 2) {
            return tmp[1].length();
        }
        return 0;
    }

    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    public static boolean isValid(String n) {
        // \d - digits
        return n.matches("\\d{0,5}");
    }

    public static boolean isStrangePair(String a, String b) {
        return (a.length() == 0 && b.length() == 0) ||
                (a.charAt(0) == b.charAt(b.length()-1) && a.charAt(a.length()-1) == b.charAt(0));
    }

    public static boolean isPrefix(String a, String b) {
        return a.startsWith(b.replaceAll("-", ""));

    }

     public static boolean isSuffix(String a, String b) {
         return a.endsWith(b.replaceAll("-", ""));
     }

     public static int boxSeq(int n) {
         return (n%2)*3 + (n/2)*2;
     }
}