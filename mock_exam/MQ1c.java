
class Q1c {

    private String title;
    int qsNumber;
    private int marks;
    private static int MQUESTION_COUNT = 0;

    //> main
    public static void main(String[] args) {
        Q1c q1c = new Q1c();
        System.out.println(q1c.toString());
        q1c.setTitle("title");
        q1c.setQsNumber(1);
        q1c.setMarks(10);
        System.out.println(q1c.toString());
        Q1c q1c_Again = new Q1c();
        System.out.println(q1c_Again.toString());
    }

    //> constructors
    public Q1c() {
        this.title = "untitled";
        this.qsNumber = 0;
        this.marks = 0;
        this.MQUESTION_COUNT += 1;
    }

    public Q1c(String title, int qsNumber, int marks) {
        this.title = title;
        this.qsNumber = qsNumber;
        this.marks = marks;
        this.MQUESTION_COUNT += 1;
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
        return qsNum + " " + this.title + " " + marks + " " + this.MQUESTION_COUNT;
    }

}
