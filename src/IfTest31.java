public class IfTest31 {
    public static void main(String[] args) {
        int x = 10;
        if (x > 0) {
            int y = 20;
        }
        // 変数yのスコープ街で変数yを利用するコードなので、コンパイルエラーになる.
        // y cannot be resolved to a variable
        System.out.println(y);
    }
}
