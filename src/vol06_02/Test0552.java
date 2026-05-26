package vol06_02;

public class Test0552 {
    public static void main(String[] args) {
        int i = 0, j = 5;
        for (; i < 5; i++) {
            for (; j > 0; j--) {
                switch (i + j) {
                    case 3:
                        break;
                }
                System.out.println("i=" + i + " j=" + j);
            }
        }
    }
}
