package vol06_02;

public class Test0546 {
    public static void main(String[] args) {
        for (int i = 1, j = 3; i + j <= 10; i++, j++) {
            System.out.println(++i + ":" + ++j);
        }
    }
}
