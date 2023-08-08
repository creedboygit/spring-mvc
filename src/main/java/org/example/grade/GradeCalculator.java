package org.example.grade;

import java.util.List;

public class GradeCalculator {

    private final Courses courses;

    public GradeCalculator(List<Course> courses) {

        this.courses = new Courses(courses);
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수 * 교과목 평점)의 합계 / 수강신청 총 학점 수
     * 일급 컬렉션 사용
     */
    // 이수한 과목을 전달하여 평균 학점 계산 요청 --> 학점 계산기에게 요청 --> (학점수 * 교과목 평점)의 합계, 수강신청 총학점 수 --> 과목(코스)에게 일임 --> 일급 컬렉션에게 일임
    public double calculateGrade() {

        // (학점수 * 교과목 평점)의 합계
        double totalMultiplyCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultiplyCreditAndCourseGrade / totalCompletedCredit;
    }
}
