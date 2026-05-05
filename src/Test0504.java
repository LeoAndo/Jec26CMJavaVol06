public class Test0504 {
    public static void main(String[] args) {
        int x = 3;
        // The operator < is undefined for the argument type(s) boolean, int
        if (-5 < x < 5) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
