package dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
    /*1,1,2, 3, 5, 8*/
    /*greedy approach, time complexity - 2 to the power of n*/
    public static int getFibonacciNumber(int n){
        if(n == 1 || n == 2) return 1;
        return getFibonacciNumber(n-1) + getFibonacciNumber(n-2);
    }

    //optimized solution, time complexity of O(N)
    public static int getFibonacciNumber(int n, int[] fib){
        if(fib[n] > 0){
            return fib[n];
        }

        if(n == 1 || n ==2){
            fib[n] = 1;
            return 1;
        }

        int number = getFibonacciNumber(n-1, fib) + getFibonacciNumber(n-2, fib);
        fib[n] = number;
        return number;
    }

    /*bottom up approach, time complexity O(n)*/
    public static int getFibonacciNumber(int number, boolean abc){
        if(number == 1 || number == 2) return 1;
        int[] fibs = new int[number+1];
        fibs[1] = 1;
        fibs[2] = 1;
        for(int i =3; i<= number; i++){
            fibs[i] = fibs[i-1] + fibs[i-2];
        }
        return fibs[number];
    }

    public static void main(String[] args) {
        System.out.println(getFibonacciNumber(8));
        int[] fib = new int[9];
        Arrays.fill(fib, -1);
        System.out.println(getFibonacciNumber(8, fib));
        System.out.println(getFibonacciNumber(8, false));
    }
}
