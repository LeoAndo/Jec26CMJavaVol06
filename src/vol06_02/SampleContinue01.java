package vol06_02;

public class SampleContinue01 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                continue;
            }
            System.out.println(i);
        }
    }
}
