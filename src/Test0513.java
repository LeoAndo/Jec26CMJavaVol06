public class Test0513 {
    public static void main(String[] args) {
        int x = 10;
        boolean b = false;
        if (b = !b) {
            System.out.print(x = 2 * x);
        } else {
            System.out.print(b);
        }
    }
}
