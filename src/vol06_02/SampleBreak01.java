package vol06_02;

public class SampleBreak01 {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i > 2) {
                break;
            }
            System.out.println(i);
            i++;
        }
    }
}
