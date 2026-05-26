package vol06_02;

public class SampleLabel03 {
    public static void main(String[] args) {
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i == 2) {
                    continue outerLoop;
                }
                System.out.println(i + ":" + j);
            }
        }
    }
}
