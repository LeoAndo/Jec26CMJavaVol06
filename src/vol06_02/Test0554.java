package vol06_02;

public class Test0554 {
    public static void main(String[] args) {
        int x = 0, y = 0;
        outer: for (;;) {
            x++;
            inner: y++;
            if ((x + y) % 3 == 0)
                break outer;

            if ((x + y) % 5 == 0)
                continue outer;

            if ((x + y) % 4 == 0)
                continue inner; // The label inner is missing

            x++;
        }
    }
}
