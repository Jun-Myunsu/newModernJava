package org.example;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest {

    public static void main(String[] args) {

        Student[] arr = new Student[9];

        arr[0] = new Student(3, 70);	// 3반 70점
        arr[1] = new Student(1, 70);	// 1반 70점
        arr[2] = new Student(1, 50);	// 1반 50점
        arr[3] = new Student(2, 60);	// 2반 60점
        arr[4] = new Student(2, 80);	// 2반 80점
        arr[5] = new Student(1, 30);	// 1반 30점
        arr[6] = new Student(2, 70);	// 2반 70점
        arr[7] = new Student(3, 90);	// 3반 90점
        arr[8] = new Student(3, 60);	// 3반 60점

        Student[] arr2 = arr.clone();	// 정렬 테스트를 위한 arr 객체 복사
        Student[] arr3 = arr.clone();	// 정렬 테스트를 위한 arr 객체 복사

        System.out.println("(c, s) -> (classNum, score)");
        // 정렬 이전
        System.out.print("정렬 전 : ");
        for(Student v : arr) {
            System.out.print(v);
        }
        System.out.println();

        Arrays.sort(arr);	// Comparable 사용


        System.out.print("\n학급 오름차순 정렬(같을 경우 성적 내림차순) : ");
        for(Student v : arr) {
            System.out.print(v);
        }
        System.out.println();

        Arrays.sort(arr2, comp1);	// Comparator 사용

        System.out.print("\n학급 오름차순 정렬(같을 경우 성적 오름차순) : ");
        for(Student v : arr2) {
            System.out.print(v);
        }
        System.out.println();



        Arrays.sort(arr3, comp2);	// Comparator 사용

        System.out.print("\n성적 내림차순 정렬(같을 경우 학급 오름차순) : ");
        for(Student v : arr3) {
            System.out.print(v);
        }
        System.out.println();

    }


    static Comparator<Student> comp1 = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {

            // 만약 학급이 같다면 성적을 기준으로 "오름차순"으로 정렬한다.
            if(o1.classNum == o2.classNum) {
                return o1.score - o2.score;
            }
            return o1.classNum - o2.classNum;	// 학급 기준 오름차순으로 정렬한다.
        }
    };

    static Comparator<Student> comp2 = new Comparator<Student>() {

        @Override
        public int compare(Student o1, Student o2) {

            // 만약 성적이 같다면 학급을 "오름차순"으로 정렬한다.
            if(o1.score == o2.score) {
                return o1.classNum - o2.classNum;
            }
            return o2.score - o1.score;	// 성적을 내림차순으로 정렬한다.
        }
    };
}


class Student implements Comparable<Student> {

    int classNum;
    int score;

    public Student(int classNum, int score) {
        this.classNum = classNum;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {

        // 만약 학급이 같다면 성적을 기준으로 "내림차순"으로 정렬한다.
        if(this.classNum == o.classNum) {
            return o.score - this.score;
        }
        return this.classNum - o.classNum;	// 학급 기준 오름차순으로 정렬한다.
    }


    @Override
    public String toString() {
        return "("+classNum + ", " + score + ")  ";
    }

}