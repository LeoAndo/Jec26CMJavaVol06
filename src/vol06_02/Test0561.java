package vol06_02;

public class Test0561 {
    public static void main(String[] args) {
        int i = 0, j = 0;
        while (i < 4) {
            i++;
            while (j < 3) {
                j++;
            }
            break;
        }
        System.out.println(i);
        System.out.println(j);
    }
}
