public class Test0512 {
    public static void main(String[] args) {
        boolean b = false;
        if (!b) {
            int y = 3;
            y -= 2;
        }
        // y cannot be resolved to a variable
        System.out.println(b + ":" + y);
    }
}
