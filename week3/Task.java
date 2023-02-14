import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {

    final String title;
    String description;
    LocalDate scheduled;
    LocalDate deadline;
    State state;


    Task(String title, State state) { 
        this.title = title;
        this.state = state;
    }

    Task(String title, State state, String description, LocalDate scheduled, LocalDate deadline) { 
        this.title = title;
        this.state = state;
        this.description = description;
        this.scheduled = scheduled;
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getScheduled() {
        return scheduled;
    }

    public String toString() {
    String message = this.title + " (" + this.state + ")";

        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }

        if (deadline != null) {
            message += " deadline: " + deadline;
        }

        return message;
    }

}

class RepeatedTask extends Task {

    RepeatedTask(String title, State state) {
        super(title, state);
    }

    public void setState(State state) {
        if (state == State.DONE) {
            this.state = State.TODO;
        }
    }

}

class SharedTask extends Task {

    String sharedWith;

    SharedTask(String title, String sharedWith) {
        super(title, State.WAIT);
        this.sharedWith = sharedWith;
    }

    public void setState(State state) {
        if (state == State.DONE) {
            this.state = State.WAIT;
        }
    }

    public String toString() {
        return super.toString() + " shared with: " + sharedWith;
    }

}

class Depdency extends Task {
        Task dependency;
    
        Depdency(String title, State state, Task dependency) {
            super(title, state);
            this.dependency = dependency;
        }
    
        public void setState(State state) {
            if (state == State.DONE) {
                if (dependency.state == State.DONE) {
                    this.state = State.DONE;
                }
            }
        }
    
        public String toString() {
            return super.toString() + " dependent on: " + dependency;
        }
}

 class Chore extends Task {
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    public void setState(State state) {
        if (state == State.DONE) {
            LocalDate repeat_new = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(repeat_new);
        }
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

}