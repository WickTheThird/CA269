import java.util.*;

class PreferLowerValues implements Comparator<Value> {
    public int compare(Value value1, Value value2) {
        // set to sort lower values first
        return value2.compareTo(value1);
    }
}

class PreferHigherValues implements Comparator<Value> {
    public int compare(Value value1, Value value2) {
       return value1.compareTo(value2);
    }
}

class Value implements Comparable<Value> {

    private static boolean SORT_LOWER;
    final int value;

    // initialization
    public Value(int val) {
        this.value = val;
    }

    // main testing
    public static void main(String... args) {
        List<Value> list = Arrays.asList(
                new Value(2), new Value(3), new Value(1));

        Value.setSortLower();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [1, 2, 3]

        Value.setSortHigher();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [3, 2, 1]
    }

    // compare method used in sorting
    public int compareTo(Value value) {
        if (isSortLower()) {
            return Integer.compare(this.value, value.value);
        }
        return Integer.compare(value.value, this.value);
    }

    // getters and setters
    public int getValue() {
        return value;
    }

    public String toString() {
        return Integer.toString(value);
    }

    public static void setSortLower() {
        SORT_LOWER = true;
    }

    public static void setSortHigher() {
        SORT_LOWER = false;
    }

    public static boolean isSortLower() {
        if (SORT_LOWER == false) {
            return false;
        }
        return SORT_LOWER;
    }

    public static boolean isSortHigher() {
        if (SORT_LOWER == true) {
            return false;
        }
        return SORT_LOWER;
    }

}
