package com.tnaot.page;

import com.google.gson.annotations.SerializedName;

public class MongoPage {
    /**
     * userName : oven
     * userId : 1234567
     */

    @SerializedName("userName")
    private String userName;
    @SerializedName("userId")
    private String userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
