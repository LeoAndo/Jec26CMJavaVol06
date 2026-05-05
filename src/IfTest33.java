public class IfTest33 {
    public static void main(String[] args) {
        int x = -10;
        int y = 5;
        if (x > 0) {
            // Duplicate local variable y
            int y = -5;
            System.out.println(y);
        }
    }
}
