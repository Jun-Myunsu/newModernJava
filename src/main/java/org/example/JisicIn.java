package org.example;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;



public class JisicIn {

    public record memberRecord(String name, int age) {}

    public static void main(String...args) {
        memberRecord member1 = new memberRecord("jun", 13);
        memberRecord member2 = new memberRecord("han", 14);

        System.out.println(member1.equals(member2));
        System.out.println(member1.name());
        System.out.println(member1.age());


//
//        if (o instanceof JisicIn) {
//            GrapeClass grape = (GrapeClass) o;
//            System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
//        }
NumberFormat fmt = NumberFormat.getCompactNumberInstance(
        Locale.KOREA, NumberFormat.Style.SHORT);
System.out.println(fmt.format(1000));
System.out.println(fmt.format(100000));
System.out.println(fmt.format(1000000));

fmt = NumberFormat.getCompactNumberInstance(
        Locale.ENGLISH, NumberFormat.Style.LONG);
System.out.println(fmt.format(1000));
System.out.println(fmt.format(100000));
System.out.println(fmt.format(1000000));


DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B", Locale.ENGLISH);
System.out.println(dtf.format(LocalTime.of(8, 0)));
System.out.println(dtf.format(LocalTime.of(13, 0)));
System.out.println(dtf.format(LocalTime.of(20, 0)));
System.out.println(dtf.format(LocalTime.of(23, 0)));
System.out.println(dtf.format(LocalTime.of(0, 0)));

String periodOfDay = DateTimeFormatter.ofPattern("B", Locale.ENGLISH).format(LocalDateTime.now());
System.out.println(periodOfDay);
    }






//    static int sNum, tNum;
//    static int answer = Integer.MAX_VALUE;
//    static int cnt = 0;
//
//
//    public static void Test(int sNum) {
//        if (sNum > tNum) {
//            return;
//        } else if (sNum < tNum) {
//            cnt++;
//            Test(sNum * 2);
//            Test(Integer.parseInt(String.valueOf(sNum) + "1"));
//            cnt--;
//            System.out.println("sNum : " + sNum + ", " + cnt);
//        } else {
//            if (answer > cnt) answer = cnt;
//        }
//    }
//
//    public static void main(String...args) {
//        Scanner kb = new Scanner(System.in);
//
//        sNum = kb.nextInt();
//        tNum = kb.nextInt();
//
//        JisicIn.Test(sNum);
//
//        if (Integer.MAX_VALUE == answer) System.out.println(-1);
//        else System.out.println(answer+1);
//    }
//

//    public static void main(String[] args) {
//
//        int[] num = new int[3];
//        for (int i = 0; i < num.length; i++) {
//            num[i] = (int) (Math.random() * 6) + 1; // 1~6 임의의 숫자
//            System.out.println(i +  "번째 주시위 수 : " + num[i]);
//        }
//
//        int overlap = 0;    // 같은 숫자가 나오는 수
//        int samenum = 0;    // 같은 숫자
//        int max = 0;    // 최대값
//
//        // 순화하며 중복된 값이 있는 비교
//        for (int i = 0; i < num.length; i++) {
//            for (int j = i + 1; j < num.length; j++) {
//
//                // 동일한 값이 있을 경우 중복된 수를 더해줌
//                if (num[i] == num[j]) {
//                    overlap++;
//                    samenum = num[i];
//                }
//            }
//
//            // 최대값 저장
//            if (max < num[i]) max = num[i];
//        }
//
////        같은 눈이 3개가 나오면 10,000원 + (같은 눈) × 1,000원의 상금을 받게 된다.
////        같은 눈이 2개만 나오는 경우에는 1,000원 + (같은 눈) × 100원의 상금을 받게 된다.
////        모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈) × 100원의 상금을 받게 된다.
//
//        System.out.println("같은 눈의 수 : " + overlap);
//        System.out.println("같은 수 : " + samenum);
//        System.out.println("최대값 : " + max);
//
//
//        int result = 0;
//        // 같은 눈 3개
//        if (overlap == 2) {
//            result = 10000 + (samenum * 1000);
//            System.out.println("같은 눈 3개 : " + String.format("$%,d", result));
//        // 같은 눈 2개
//        } else if (overlap == 1) {
//            result = 10000 + (samenum * 100);
//            System.out.println("같은 눈 2개 : " + String.format("$%,d", result));
//        // 모두 다른 눈
//        } else {
//            result = max * 100;
//            System.out.println("모두 다른 눈 : " + String.format("$%,d", result));
//        }
//    }
}