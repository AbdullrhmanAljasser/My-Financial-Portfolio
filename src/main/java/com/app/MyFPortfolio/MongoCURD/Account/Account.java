package com.app.MyFPortfolio.MongoCURD.Account;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    public static ConcurrentMap<String, ArrayList<Account>> accounts = new ConcurrentHashMap<>();

    public String f_account_id;
    public String currency; // Financial Profile Type: -Spending -Gain
    public float balance;
    public String user_id; // Account ID affected
    public Date created_at;
    
    public Account() {}

    @JsonCreator
    public Account(@JsonProperty("f_account_id") String f_account_id, @JsonProperty("balance") float balance,
    @JsonProperty("currency") String currency, @JsonProperty("user_id") String user_id, @JsonProperty("created_at") Date created_at){
        this.f_account_id = f_account_id;
        this.balance = balance;
        this.currency = currency;
        this.user_id = user_id;
        this.created_at = created_at;
        if (Account.accounts.containsKey(user_id)){
            Account.accounts.get(user_id).add(this);
        } else {
            Account.accounts.put(user_id, new ArrayList<Account>());
            Account.accounts.get(user_id).add(this);
        }
    }
}
