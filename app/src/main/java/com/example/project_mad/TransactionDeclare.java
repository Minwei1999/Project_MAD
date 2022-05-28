package com.example.project_mad;

public class TransactionDeclare {
    private String transCategory;
    private float transValue;
    private String transDate;
    private String transRemark;

    public TransactionDeclare(){}

    public TransactionDeclare(String transCategory, float transValue, String transDate, String transRemark){
        this.transCategory = transCategory;
        this.transValue = transValue;
        this.transDate = transDate;
        this.transRemark = transRemark;
    }

    public String getTransCategory(){
        return transCategory;
    }

    public void setTransCategory(String transCategory) {
        this.transCategory = transCategory;
    }

    public float getTransValue() {
        return transValue;
    }

    public void setTransValue(float transValue) {
        this.transValue = transValue;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransRemark() {
        return transRemark;
    }

    public void setTransRemark(String transRemark) {
        this.transRemark = transRemark;
    }
}
