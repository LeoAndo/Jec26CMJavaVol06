package vol06_02;

public class Test0553 {
    public static void main(String[] args) {
        int x = 0;
        outer: for (int i = 0; i < 10; i++) {
            x++;
            if (x < 3)
                continue outer;
            if (x + i >= 8)
                break outer;

            inner: for (int j = 0; j < 10; j++) {
                x++;
                if (x + j >= 5)
                    break inner;
            }
        }
        System.out.println(x);
    }
}
