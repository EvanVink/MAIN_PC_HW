public class Main {
    public static void main(String[] args) {

        int time = 1000;
        int n = 50;
        for (int i = 1; i <= n; i++) {
            time += 9;
            for (int k = 5; k <= i + 6; k++) {
                time += 12 * k;
                time += 4;
            }
        }

        System.out.println("Sum 1: " + time);


    }
}