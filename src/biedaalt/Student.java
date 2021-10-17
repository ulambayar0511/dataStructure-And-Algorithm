package biedaalt;

import dataStructures.Chain;

public class Student {

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGPA() {
        float sum = 0;
        for (int i = 0; i < lessons.size(); i++) {
            sum += pointToFloat(((Lessons) lessons.get(i)).getScore());
        }
        GPA = sum / lessons.size();
        return GPA;
    }

    public float pointToFloat(float point) {
        float gpa = 0;
        if (point >= 96 && point <= 100)
            gpa = (float) 4.0;
        else if (point >= 91 && point < 96)
            gpa = (float) 3.7;
        else if (point >= 88 && point < 91)
            gpa = (float) 3.4;
        else if (point >= 84 && point < 88)
            gpa = (float) 3.0;
        else if (point >= 81 && point < 84)
            gpa = (float) 2.7;
        else if (point >= 78 && point < 81)
            gpa = (float) 2.4;
        else if (point >= 74 && point < 78)
            gpa = (float) 2.0;
        else if (point >= 71 && point < 74)
            gpa = (float) 1.7;
        else if (point >= 68 && point < 71)
            gpa = (float) 1.3;
        else if (point >= 64 && point < 68)
            gpa = (float) 1.0;
        else if (point >= 60 && point < 64)
            gpa = (float) 0.7;
        else if (point >= 0 && point < 60)
            gpa = (float) 0.0;
        return gpa;
    }

    public Chain getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lesson) {

        lessons.add(lessons.size(), lesson);
        // Lessons lessons = new Lessons();

    }

    // Оюутан
    public String code;// код Оюутны код
    public float GPA;// голч дүн
    public Chain lessons = new Chain();// үзсэн хичээл

}
