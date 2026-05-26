package vol06_02;

public class SampleWhile03 {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            int x = 0;
            System.out.println(i + "回目:" + x);
            x++;
            i++;
        }
        System.out.println("**終了**");
    }
}
