class Studentdetails {
    String name;
    int marks1;
    int marks2;
    char grade;
    double gpa;
    boolean isGraded;

    Studentdetails(String name, int marks1, int marks2) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.isGraded = false;
    }

    synchronized void calculateGradeAndGPA() {
        if (isGraded) {
            return;
        }

        int totalMarks = marks1 + marks2;
        if (totalMarks >= 80) {
            grade = 'A';
            gpa = 10.0;
        } else if (totalMarks >= 60) {
            grade = 'B';
            gpa = 8.0;
        } else {
            grade = 'C';
            gpa = 6.0;
        }

        isGraded = true;
        notify();
    }

    synchronized void displayGradeAndGPA() {
        while (!isGraded) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Name: " + name + " Grade: " + grade + " GPA: " + gpa);
    }
}

class Assign extends Thread {
    Studentdetails s;

    Assign(Studentdetails s) {
        this.s = s;
    }

    public void run() {
        s.calculateGradeAndGPA();
    }
}

class Display extends Thread {
    Studentdetails s;

    Display(Studentdetails s) {
        this.s = s;
    }

    public void run() {
        s.displayGradeAndGPA();
    }

}

public class Student {
    public static void main(String[] args) {
        Studentdetails[] students = new Studentdetails[5];
        students[0] = new Studentdetails("Alice", 85, 70);
        students[1] = new Studentdetails("Bob", 75, 80);
        students[2] = new Studentdetails("Charlie", 95, 90);
        students[3] = new Studentdetails("David", 60, 70);
        students[4] = new Studentdetails("Eve", 80, 65);
        Assign[] AssignThread = new Assign[5];
        Display[] displaysThread = new Display[5];
        for (int i = 0; i < 5; i++) {
            AssignThread[i] = new Assign(students[i]);
            AssignThread[i].start();
        }
        for (int i = 0; i < 5; i++) {
            displaysThread[i] = new Display(students[i]);
            displaysThread[i].start();
        }

    }

}
