package vol06_02;

public class Test0551 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i % 3 == 1)
                continue;
            for (int j = 5; j > 0; j--) {
                if ((i + j) % 4 == 0)
                    break;
                System.out.println("i=" + i + " j=" + j);
            }
        }
    }
}
