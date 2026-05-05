import java.util.Scanner;

// Ex0101.java
// 21cm0101 安藤
public class SampleSwitchBreak01_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // キーボード入力した値をxに代入.
        switch (x) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
            case 3:
                System.out.println("Three");
        }
        sc.close();
    }
}
