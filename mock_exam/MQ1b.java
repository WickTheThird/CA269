
class Q1b {

    private String title;
    int qsNumber;
    private int marks;

    //> main
    public static void main(String[] args) {
        Q1b q1b = new Q1b();
        System.out.println(q1b.toString());
        q1b.setTitle("title");
        q1b.setQsNumber(1);
        q1b.setMarks(10);
        System.out.println(q1b.toString());
    }

    //> constructors
    public Q1b() {
        this.title = "untitled";
        this.qsNumber = 0;
        this.marks = 0;
    }

    public Q1b(String title, int qsNumber, int marks) {
        this.title = title;
        this.qsNumber = qsNumber;
        this.marks = marks;
    }

    //> getters
    public String getTitle() {
        return this.title;
    }

    public int getQsNumber() {
        return this.qsNumber;
    }

    public int getMarks() {
        return this.marks;
    }

    //> setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setQsNumber(int qsNumber) {
        this.qsNumber = qsNumber;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    //> to string
    public String toString() {
        String qsNum = String.valueOf(this.qsNumber);
        String marks = String.valueOf(this.marks);
        return qsNum + " " + this.title + " " + marks;
    }

}
