package com.cronnoss.hr_staff_rest_api_spring_data_jpa.service;

import java.sql.Timestamp;

public class ReportRequest {
    private Timestamp from;
    private Timestamp to;

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }
}