import java.time.Period

class Chore extends Task {
    // think how to use inheritence to avoid repeating fields from Task
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        // parameters are the mandatory fields
        // super() is to ensure parent constructor is called - otherwise we get Errors!
        super(title, state);
        // even in constructor, defer to setters
        // because there may be input validation, default values, etc. implemented in them
        setScheduled(scheduled);
        setRepeat(repeat);
    }
}