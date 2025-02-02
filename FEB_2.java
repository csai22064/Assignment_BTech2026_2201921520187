package JAN_27;

import java.io.FileReader;
import java.io.IOException;

public class FEB_2 {
    public static void main(String[] args) {
        try {
            try {
                FileReader f = new FileReader("hello.txt");
            } catch (IOException e) {
                System.out.println(e);
            }
            int divide = 12/0;
        } catch (ArithmeticException | ClassCastException e) {
            System.out.println(e);
        }
    }
}
