package com.app.MyFPortfolio.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthLogin {
    private final String user_id;
    private final String user_pwd;

    @JsonCreator
    public AuthLogin(@JsonProperty("user_id") String user_id, @JsonProperty("user_pwd") String user_pwd) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
    }

    public String getUserID() {
        return this.user_id;
    }

    public String getUserPwd() {
        return this.user_pwd;
    }
}
