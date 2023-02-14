import java.time.LocalDate;

class Task {
    // think why private is the WRONG choice here
    // instead, think what should be the access modifier
    private final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline; // think why this isn't final
    private State state;

    public String getTitle() {
        return title;
    }

    // NOT ALLOWED - think why
    // public void setTitle(String title) {
    //     this.title = title;
    // }

    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }

    // and so on ...



}