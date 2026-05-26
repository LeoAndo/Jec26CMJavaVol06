public class Test0507 {
    public static void main(String[] args) {
        int x = 0;
        if (x++ > 0) {
            System.out.print("A");
        } else {
            System.out.print("B");
        }
        System.out.print(":" + x);
    }
}
