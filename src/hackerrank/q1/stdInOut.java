package hackerrank.q1;

import java.io.*;
import java.util.*;

public class stdInOut {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = {0,0,0};
        for(int x =0;x < 3; x++ ) {

            int myInt = scanner.nextInt();
            ints[x] = myInt;

        }
        for(int c : ints) {
            System.out.println(c);
        }
        scanner.close();
    }
}

