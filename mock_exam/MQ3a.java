import java.util.*;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

class Classroom {
    List<Student> students = new ArrayList<Student>();

    //? main
    public static void main(String[] args) {
        Classroom c = new Classroom();
        Student s = new Student();
        s.setMarks(90);
        c.addStudent(s);
        System.out.println(c.getStudents());
        System.out.println(c.getGradedStudents(80));
        System.out.println(c.getAverageMarks());
        System.out.println(c.isStudentPresent(s));
    }

    //? getter
    public List<Student> getStudents() {
        return students;
    }

    //? adding students
    public void addStudent(Student s) {
        students.add(s);
    }

    //? getting graded students
    public List getGradedStudents(int marks) {
        
        List<Student> gradedStudents = new ArrayList<Student>();
        for (Student s : students) {
            if (s.getMarks() >= marks) {
                gradedStudents.add(s);
            }
        }
        return gradedStudents;

    }

    //? getting the average marks
    public int getAverageMarks() {
        return students.stream().mapToInt(Student::getMarks).sum() / students.size();
    }

    //? checking if a student is part of a classroom
    public boolean isStudentPresent(Student s) {
        return students.stream().anyMatch(student -> student.equals(s));
    }


}

