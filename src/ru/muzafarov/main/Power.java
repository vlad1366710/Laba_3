package ru.muzafarov.main;

public class Power {

    public static double power(String xStr, String yStr) {
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);
        return Math.pow(x, y);
    }

}
