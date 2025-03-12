package org.example.design;

import java.time.LocalDate;
import java.util.List;

public class TourPlan {
    private String title; // 여행 제목
    private LocalDate startDate; // 출발 일
    private int nights; // 몇 박
    private int days; // 며칠
    private String whereToStay; // 어디서 머물지
    private List<DetailPlan> plans; // n일차 할 일

    public TourPlan(String title, LocalDate startDate, int nights, int days, String whereToStay, List<DetailPlan> plans) {
        this.title = title;
        this.startDate = startDate;
        this.nights = nights;
        this.days = days;
        this.whereToStay = whereToStay;
        this.plans = plans;
    }
}