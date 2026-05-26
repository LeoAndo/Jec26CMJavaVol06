import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int hankei = sc.nextInt(); // キーボード入力した値をxに代入.
            int area = (int) (hankei * hankei * 3.14);
            System.out.println("円の半径を入力してください＞" + hankei);
            System.out.println("円の面積は" + area + "です");
        } catch (InputMismatchException ex) {
            System.out.println("数値を入力してください");
        } finally {
            sc.close();
        }
    }
}
