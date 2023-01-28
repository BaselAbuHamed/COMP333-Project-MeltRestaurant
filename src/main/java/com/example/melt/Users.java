package com.example.melt;

public class Users {
    private int userId;
    private String userName;
    private String password;
    private int userRuleId;

    public Users(int userId, String userName, String password, int userRule) {
        this.userId = userId;
        this.userName= userName;
        this.password = password;
        this.userRuleId=userRule;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName= userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRuleId() {
        return userRuleId;
    }

    public void setUserRuleId(int userRuleId) {
        this.userRuleId = userRuleId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + userId+
                ", name='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", RuleId=" + userRuleId +
                '}';
    }
}
