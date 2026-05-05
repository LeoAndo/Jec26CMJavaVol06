public class Test0522 {
    public static void main(String[] args) {
        long x = 2;
        // Cannot switch on a value of type long. Only convertible int values, strings
        // or enum variables are permitted
        switch (x) {
            case 1:
                x *= 10;
            case 2:
                x += 2;
                break;
            default:
                ++x;
        }
        System.out.println(x);
    }
}
