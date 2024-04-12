package com.atmajo.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_tab")
public class Payment {

    @Id
    private Long enrollment;
    private String semester;
    private String txid;
    private Long amount;

    public Payment(){}

    public Payment(Long enrollment, String semester, String txid, Long amount) {
        this.enrollment = enrollment;
        this.semester = semester;
        this.txid = txid;
        this.amount = amount;
    }

    public Long getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Long enrollment) {
        this.enrollment = enrollment;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
