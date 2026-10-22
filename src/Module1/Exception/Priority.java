package Module1.Exception;

import java.util.*;

public class Priority {

    public static int Priority() {
        try {
            System.out.println("1. Inside try block");
            return 10;
        } catch (Exception e) {
            System.out.println("Inside catch block");
            return 20;
        } finally {
            System.out.println("2. Inside finally block");
        }
    }

    public static void main(String[] args) {
        int result = Priority();
        System.out.println("3. Final Result received in main: " + result);
    }
}