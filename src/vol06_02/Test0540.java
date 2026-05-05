package vol06_02;

public class Test0540 {
    public static void main(String[] args) {
        short s = 1;
        do {
            s++;
            System.out.print("*");
        } while (1); // Type mismatch: cannot convert from int to boolean
    }
}
