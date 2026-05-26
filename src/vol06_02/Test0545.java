package vol06_02;

public class Test0545 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10;) {
            if (i <= 3) {
                i++;
            } else {
                i *= 2;
            }
            System.out.print(i + " ");
        }
    }
}
