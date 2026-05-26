package vol06_02;

public class SampleContinue03 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == j) {
                    continue;
                }
                System.out.println(i + ":" + j);
            }
        }
    }
}
