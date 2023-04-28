class Q1a {
    String title;
    int qsNumber;
    int marks;

    //> constructor
    public void Q1a(String title, int qsNumber, int marks) {
        this.title = title;
        this.qsNumber = qsNumber;
        this.marks = marks;
    }

    //> to string
    public String toString() {
        String qsNum = String.valueOf(this.qsNumber);
        String marks = String.valueOf(this.marks);
        return qsNum + " " + this.title + " " + marks;
    }


}

