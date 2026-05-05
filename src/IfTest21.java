public class IfTest21 {
    public static void main(String[] args) {
        int x = 10;
        int y;
        if (x > 0) {
            y = 7;
        }
        // The local variable y may not have been initialized
        System.out.println(y);
    }
}
