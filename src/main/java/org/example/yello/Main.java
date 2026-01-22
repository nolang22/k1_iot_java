package org.example.yello;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println(A * (B % 10));
        System.out.println(A * ((B / 10) % 10));
        System.out.println(A * (B / 100));
        System.out.println(A * B);
    }
}
