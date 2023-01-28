package com.example.melt;

public class Rules {
    private int ruleId;
    private String ruleTitle;
    public Rules() {}

    public Rules(int ruleId, String ruleTitle) {
        this.ruleId = ruleId;
        this.ruleTitle = ruleTitle;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleTitle() {
        return ruleTitle;
    }

    public void setRuleTitle(String ruleTitle) {
        this.ruleTitle = ruleTitle;
    }

    @Override
    public String toString() {
        return "Rules{" +
                "ruleId=" + ruleId +
                ", ruleTitle='" + ruleTitle + '\'' +
                '}';
    }
}
