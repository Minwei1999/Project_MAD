package com.example.project_mad;

public class Budget {
    private String budgetCategory;
    private float budgetGoal;
    private String budgetDate;

    public Budget(){}

    public Budget(String budgetCategory, float budgetGoal, String budgetDate) {
        this.budgetCategory = budgetCategory;
        this.budgetGoal = budgetGoal;
        this.budgetDate = budgetDate;
    }

    public String getBudgetCategory() {
        return budgetCategory;
    }

    public void setBudgetCategory(String budgetCategory) {
        this.budgetCategory = budgetCategory;
    }

    public float getBudgetGoal() {
        return budgetGoal;
    }

    public void setBudgetGoal(float budgetGoal) {
        this.budgetGoal = budgetGoal;
    }

    public String getBudgetDate() {
        return budgetDate;
    }

    public void setBudgetDate(String budgetDate) {
        this.budgetDate = budgetDate;
    }
}
