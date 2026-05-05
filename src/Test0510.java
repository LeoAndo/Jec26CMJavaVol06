public class Test0510 {
    public static void main(String[] args) {
        int x = 2, y = 3;
        if (x++ == 0 & y++ >= 3) {
            System.out.print("A");
        } else {
            System.out.print("B");
        }
        System.out.print(":" + x + ":" + y);
    }
}
