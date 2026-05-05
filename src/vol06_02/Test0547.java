package vol06_02;

public class Test0547 {
    public static void main(String[] args) {
        int a = 1;
        for (int b = 1; b < 8; ++b) {
            if (a == b) {
                b *= 2;
            } else {
                b = b + 1;
            }
        }
        // b cannot be resolved to a variable
        System.out.println(a + ":" + b);
    }
}
