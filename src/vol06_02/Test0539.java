package vol06_02;

public class Test0539 {
    public static void main(String[] args) {
        byte a = 1;
        byte b = 0;
        do {
            b++;
            a = a + b;
            System.out.print("*");
        } while (a < 5);
    }
}
