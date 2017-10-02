public class countExecuted {
    private static int count = 0;

    public countExecuted() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
