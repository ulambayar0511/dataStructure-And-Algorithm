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
        return GPA;
    }

    public void setGPA(float point) {

        if (point >= 96 && point <= 100)
            GPA = (float) 4.0;
        else if (point >= 91 && point < 96)
            GPA = (float) 3.7;
        else if (point >= 88 && point < 91)
            GPA = (float) 3.4;
        else if (point >= 84 && point < 88)
            GPA = (float) 3.0;
        else if (point >= 81 && point < 84)
            GPA = (float) 2.7;
        else if (point >= 78 && point < 81)
            GPA = (float) 2.4;
        else if (point >= 74 && point < 78)
            GPA = (float) 2.0;
        else if (point >= 71 && point < 74)
            GPA = (float) 1.7;
        else if (point >= 68 && point < 71)
            GPA = (float) 1.3;
        else if (point >= 64 && point < 68)
            GPA = (float) 1.0;
        else if (point >= 60 && point < 64)
            GPA = (float) 0.7;
        else if (point >= 0 && point < 60)
            GPA = (float) 0.0;
    }

    public Chain getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        lessons.setLearned(lessons.getLearned());
        // Lessons lessons = new Lessons();
        //
        // lessons.learned = (Subject) lessChain.get(0);
        // lessons.score = (int) lessChain.get(1);

    }

    // Оюутан
    public String code;// код
    public float GPA;// голч дүн
    public Chain lessons;// үзсэн хичээлүүд
}
