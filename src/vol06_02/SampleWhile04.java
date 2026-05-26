package vol06_02;

public class SampleWhile04 {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            int x = 0;
            System.out.println(i + "回目" + x);
            x++;
            i++;
        }
        System.out.println(x); // x cannot be resolved to a variable
    }
}
