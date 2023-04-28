import java.util.*;

interface Comparable<T extends Student> {
    int compareTo(T student1, T student2);
}

class Student  {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }

}

class Classroom extends Student implements Comparable<Student> {
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

        Student s1 = new Student();
        s1.setMarks(80);
        Student s2 = new Student();
        s2.setMarks(90);

        System.out.println(c.compareTo(s1, s2));

        System.out.println(c.getGraduatingStudents());
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

    //? comparing the students
    public int compareTo(Student student1, Student student2) {
        
        if (student1.getMarks() < student2.getMarks()) {
            return -1;
        } else if (student1.getMarks() == student2.getMarks()) {
            return 0;
        } else if (student1.getMarks() > student2.getMarks()) {
            return 1;
        }

        return 404;
    }


    //? get graduating students
    public Queue<Student> getGraduatingStudents() {
        Queue<Student> graduatingStudents = new PriorityQueue<Student>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return compareTo(s1, s2);
            }
        });

        for (Student s : students) {
            if (s.getMarks() >= 40) {
                graduatingStudents.add(s);
            }
        }
 
        //? converting the queue to a list keeping its contents
        List<Student> graduatingStudentsList = new ArrayList<Student>(graduatingStudents);

        //? using collections to sort the list
        Collections.sort(graduatingStudentsList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return compareTo(s1, s2);
            }
        });

        //? convert the list to the queue
        graduatingStudents = new PriorityQueue<Student>(graduatingStudentsList);

        return graduatingStudents;
    }


}

