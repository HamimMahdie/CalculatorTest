package edu.trinity;

public class Fibonacci {

    public static int calculate(int i) {
        int sum = 0;
        if (i <= 1) {
            return i;
        }
        return calculate(i - 1) + calculate(i -2);
    }
}
