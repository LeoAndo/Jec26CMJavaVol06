package vol06_02;

public class Test0559 {
    public static void main(String[] args) {
        int a = 0;
        for (int x = 1; x < 10; x++) {
            switch (a % 3) {
                case 0:
                    x++;
                    a++;
                    break;
                case 1:
                    x += 2;
                    a = a + 1;
                    break;
                case 2:
                    x++;
                    ++a;
                    break;
            }
            System.out.print(x + " ");
        }
    }
}
