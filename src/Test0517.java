public class Test0517 {
    public static void main(String[] args) {
        int x = 5;
        int y = 0;
        switch (x / 2) {
            case 0:
                y -= 3;
            case 1:
                y += 1;
                break;
            case 2:
                y = -2;
            default:
                y = 5;
        }
        System.out.print(y);
    }
}
