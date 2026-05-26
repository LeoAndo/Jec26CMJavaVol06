public class Test0516 {
    public static void main(String[] args) {
        short s = 0;
        switch (s) {
            case 0:
                System.out.print("A");
                break;
            case 1:
                System.out.print("B");
                break;
            case 0: // Duplicate case
                System.out.print("C");
                break;
            case -20:
                System.out.print("D");
                break;
        }
    }
}
