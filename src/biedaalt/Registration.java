package biedaalt;

import dataStructures.ArrayLinearList;

public class Registration {
    public ArrayLinearList studentList;
    public ArrayLinearList subjectList = new ArrayLinearList();
    public ArrayLinearList majorList;

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

}
