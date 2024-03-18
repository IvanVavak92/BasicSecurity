package com.ivan.basicsecurityproject.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Entity
@Table(name = "notice_details")
public class Notice {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int noticeId;

    private String noticeSummary;
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    private Date noticBegDt;

    @Column(name = "notic_end_dt")
    private Date noticEndDt;
    private Date createDt;

    private Date updateDt;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeSummary() {
        return noticeSummary;
    }

    public void setNoticeSummary(String noticeSummary) {
        this.noticeSummary = noticeSummary;
    }

    public String getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(String noticeDetails) {
        this.noticeDetails = noticeDetails;
    }

    public Date getNoticBegDt() {
        return noticBegDt;
    }

    public void setNoticBegDt(Date noticBegDt) {
        this.noticBegDt = noticBegDt;
    }

    public Date getNoticEndDt() {
        return noticEndDt;
    }

    public void setNoticEndDt(Date noticEndDt) {
        this.noticEndDt = noticEndDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }
}
