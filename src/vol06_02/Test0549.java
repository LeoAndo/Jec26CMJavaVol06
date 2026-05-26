package vol06_02;

public class Test0549 {
    public static void main(String[] args) {
        for (int i = 0, j = 10; i < 5 || j > 5; i++) {
            if (i % 2 == 0) {
                j -= 2;
                continue;
            }
            System.out.println(i + ":" + j);
        }
    }
}
