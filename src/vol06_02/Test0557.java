package vol06_02;

public class Test0557 {
    public static void main(String[] args) {
        for (int x = 1;; x++) {
            if (x % 3 == 1) {
                System.out.print(x + " ");
            } else if (x % 3 == 2) {
                System.out.print(x + " ");
            } else {
                break;
            }
        }
    }
}
