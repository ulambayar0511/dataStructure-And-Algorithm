package biedaalt;

import dataStructures.ArrayLinearList;

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

}
