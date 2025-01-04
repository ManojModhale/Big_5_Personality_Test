package com.app.demo.bean;

import java.sql.Date;

public class Exam {;
    private int openness;
    private int conscientiousness;
    private int extraversion;
    private int agreeableness;
    private int neuroticism;

    public Exam() {
        super();
        this.openness = 0;
        this.conscientiousness = 0;
        this.extraversion = 0;
        this.agreeableness = 0;
        this.neuroticism = 0;
    }

    public int getOpenness() {
        return openness;
    }

    public void setOpenness(int openness) {
        this.openness = this.openness + openness;
    }

    public int getConscientiousness() {
        return conscientiousness;
    }

    public void setConscientiousness(int conscientiousness) {
        this.conscientiousness = this.conscientiousness + conscientiousness;
    }

    public int getExtraversion() {
        return extraversion;
    }

    public void setExtraversion(int extraversion) {
        this.extraversion = this.extraversion + extraversion;
    }

    public int getAgreeableness() {
        return agreeableness;
    }

    public void setAgreeableness(int agreeableness) {
        this.agreeableness = this.agreeableness + agreeableness;
    }

    public int getNeuroticism() {
        return neuroticism;
    }

    public void setNeuroticism(int neuroticism) {
        this.neuroticism = this.neuroticism + neuroticism;
    }

    @Override
    public String toString() {
        return "Exam [ openness=" + openness
                + ", conscientiousness=" + conscientiousness + ", extraversion=" + extraversion + ", agreeableness="
                + agreeableness + ", neuroticism=" + neuroticism + "]";
    }
}
