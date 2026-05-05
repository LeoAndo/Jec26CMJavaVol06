package vol06_02;

public class SampleBreak04 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == j) {
                    break;
                }
                System.out.println(i + ":" + j);
            }
        }
    }
}
