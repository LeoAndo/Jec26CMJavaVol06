package vol06_02;

public class SampleLabel04 {
    public static void main(String[] args) {
        outerLoop: for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue outerLoop;
                }
                System.out.println("    j = " + j);
            }
        }
    }
}
