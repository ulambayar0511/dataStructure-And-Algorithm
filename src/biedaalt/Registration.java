package biedaalt;

import dataStructures.ArrayLinearList;
import dataStructures.Chain;

public class Registration {
    public ArrayLinearList studentList = new ArrayLinearList();
    public ArrayLinearList subjectList = new ArrayLinearList();
    public ArrayLinearList majorList = new ArrayLinearList();

    // Нийт хичээлүүдийн жагсаалтыг харуулах
    public void setSubject(String[] elements, int index) {
        Subject subject = new Subject();
        subject.setCode(elements[0]);
        subject.setName(elements[1]);
        subject.setCredit((Float.parseFloat(elements[2])));
        subjectList.add(index, subject);

    }

    public Subject getSubject(int index) {
        return (Subject) subjectList.get(index);
    }

    public void setMajor(String[] elements, int index) {
        Major major = new Major();
        major.setCode(elements[0]);
        major.setName(elements[1]);
        majorList.add(index, major);

    }

    public Major getMajor(int index) {
        return (Major) majorList.get(index);
    }

    public void setStudent(String[] elements, int index) {
        Student student = new Student();
        student.setCode(elements[0]);
        Lessons tmpLessons = new Lessons();
        Subject subject = new Subject();
        subject.setCode(elements[1]);
        tmpLessons.setLearned(subject);
        tmpLessons.setScore((Integer.parseInt(elements[2])));
        student.setLessons(tmpLessons);

        // Chain tmp = new Chain();
        // tmp.add(0, elements[1]);
        // tmp.add(1, elements[2]);
        // student.setLessons(tmp);
        studentList.add(index, student);

    }

    public Student getStudent(int index) {
        return (Student) studentList.get(index);
    }

}
