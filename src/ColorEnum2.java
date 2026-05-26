
// 複数の定数を定義可能.
// オブジェクトの列挙が可能.
// Java SE 1.5から追加された機能.
public enum ColorEnum2 {
    RED(100), BLUE(200), GREEN(300);

    private int num;

    private ColorEnum2(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}
