package com.example.project_mad;

public class Event {
    private String location;
    private String totalBudget;
    private String daysofTravel;
    private String personCount;
    private String dateTravel;

    public Event(){}

    public Event(String location, String totalBudget, String daysofTravel, String personCount, String dateTravel) {
        this.location = location;
        this.totalBudget = totalBudget;
        this.daysofTravel = daysofTravel;
        this.personCount = personCount;
        this.dateTravel = dateTravel;
    }

    public String getDateTravel() {
        return dateTravel;
    }

    public void setDateTravel(String dateTravel) {
        this.dateTravel = dateTravel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(String totalBudget) {
        this.totalBudget = totalBudget;
    }

    public String getDaysofTravel() {
        return daysofTravel;
    }

    public void setDaysofTravel(String daysofTravel) {
        this.daysofTravel = daysofTravel;
    }

    public String getPersonCount() {
        return personCount;
    }

    public void setPersonCount(String personCount) {
        this.personCount = personCount;
    }
}
