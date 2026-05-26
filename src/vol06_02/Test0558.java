package vol06_02;

public class Test0558 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i % 3 == 1)
                continue;
            System.out.print(i + " ");
        }
    }
}
