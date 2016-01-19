/**
 * Created by aziarkash on 19-1-2016.
 */
public class TestingLoops {

    public static void main(String[] args) {

        anotherBasicForLoop(2, 3, 4);

        loopLabelExercise();

        loop1();

        loop2();

        loop3();

        loop4();

        loop5();

        switchTest();
    }

    private static void anotherBasicForLoop(int x, int y, int z) {

        // What values for x, y and z will produce the following output?
        //
        // 1 2 3 4
        // 1 2 3 4
        // 1 2 3 4
        // ----
        // 1 2 3 4
        // ----

        int j = 0, k = 0;

        for (int i = 0; i < x; i++) { // x
            do {
                k = 0;
                while (k < z) { // z
                    k++;
                    System.out.print(k + " ");
                }
                System.out.println(" ");
                j++;
            } while (j < y); // y
            System.out.println("----");
        }

        addSeparator();
    }

    private static void loopLabelExercise() {

        outer:
        for (int i = 0; i < 3; i++) {
            if (i > 1) {
                break outer;
            }
            inner:
            for (int j = 0; j < 5; j++) {
                if (j <= 3) {
                    System.out.println(j);
                } else {
                    break inner;
                }
            }
        }

        addSeparator();
    }

    private static void loop1() {

        int i;
        for (i = 0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println(i);

        addSeparator();
    }

    private static void loop2() {

        for (int i = 0, j = 5; j < 0; j--) {
            System.out.println(j);
        }

        addSeparator();
    }

    private static void loop3() {

        String java = "java";
        char[] charArray = {'j', 'a', 'v', 'a'};

        String s = "";
        for (char c : charArray) {
            s += c;
        }

        boolean bool = s.equals(java);
        System.out.println(bool);

        addSeparator();
    }

    private static void loop4() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 4) {
                    break;
                }
                System.out.println(j);
            }
        }

        addSeparator();
    }

    private static void loop5() {

        loop4:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j > 2) {
                    continue loop4;
                }
                System.out.println(j);
            }
        }

        addSeparator();
    }

    private static void switchTest() {

        switch ("3") {
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("3");
                break; // remove this for demonstration
            case "":
                System.out.println("Got it");
            default:
                System.out.println("not found");
        }

        addSeparator();
    }

    private static void addSeparator() {
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
