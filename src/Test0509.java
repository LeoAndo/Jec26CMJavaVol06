public class Test0509 {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = b1;
        if (b1 ^ !b2) {
            System.out.print("A");
        } else {
            System.out.print("B");
        }
    }
}
