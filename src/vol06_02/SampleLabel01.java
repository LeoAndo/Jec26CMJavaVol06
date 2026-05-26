package vol06_02;

public class SampleLabel01 {
    public static void main(String[] args) {
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 2) {
                    break outerLoop;
                }
                System.out.println(i + ":" + j);
            }
        }
    }
}
