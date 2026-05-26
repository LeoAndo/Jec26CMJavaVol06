public class SampleSwitchWithEnum {
    public static void main(String[] args) {
        // testColorEnum1();
        testColorEnum2();
    }

    private static void testColorEnum1() {
        ColorEnum enum1 = ColorEnum.RED;
        switch (enum1) {
            case RED:
                System.out.println("RED");
                break;
            case BLUE:
                System.out.println("BLUE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
        }
    }

    private static void testColorEnum2() {
        ColorEnum2 enum1 = ColorEnum2.BLUE;
        switch (enum1.getNum()) {
            case 100:
                System.out.println("RED: num " + enum1.getNum());
                break;
            case 200:
                System.out.println("BLUE: num " + enum1.getNum());
                break;
            case 300:
                System.out.println("GREEN: num " + enum1.getNum());
                break;
        }
    }
}
