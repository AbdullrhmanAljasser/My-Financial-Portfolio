package com.app.MyFPortfolio.MongoCURD.Financial;

import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Financial_S_G_Profile {
    public static ConcurrentMap<String, ArrayList<Financial_S_G_Profile>> profiles = new ConcurrentHashMap<>();

    public String id;
    public String f_type; // Financial Profile Type: -Spending -Gain
    public float f_amount;
    public String f_account_id; // Account ID affected
    public boolean scheduled; // Monthly? Yearly? One time?
    public Date schedule_date;
    
    public Financial_S_G_Profile() {}

    @JsonCreator
    public Financial_S_G_Profile(@JsonProperty("f_type") String f_type, @JsonProperty("f_amount") float f_amount,
    @JsonProperty("f_account_id") String f_account_id, @JsonProperty("scheduled") boolean scheduled, @JsonProperty("schedule_date") Date schedule_date){
        this.id = "50";
        this.f_type = f_type;
        this.f_amount = f_amount;
        this.f_account_id = f_account_id;
        this.scheduled = scheduled;
        this.schedule_date = schedule_date;
        if (Financial_S_G_Profile.profiles.containsKey(f_account_id)){
            System.out.println("HEREH");
            Financial_S_G_Profile.profiles.get(f_account_id).add(this);
        } else {
            System.out.println("HERE123H");
            Financial_S_G_Profile.profiles.put(f_account_id, new ArrayList<Financial_S_G_Profile>());
            Financial_S_G_Profile.profiles.get(f_account_id).add(this);
        }
    }

    public Financial_S_G_Profile(String id, String f_type, float f_amount,
    String f_account_id, boolean scheduled, Date schedule_date){
        this.id = id;
        this.f_type = f_type;
        this.f_amount = f_amount;
        this.f_account_id = f_account_id;
        this.scheduled = scheduled;
        this.schedule_date = schedule_date;
        if (Financial_S_G_Profile.profiles.containsKey(f_account_id)){
            Financial_S_G_Profile.profiles.get(f_account_id).add(this);
        } else {
            Financial_S_G_Profile.profiles.put(f_account_id, new ArrayList<Financial_S_G_Profile>());
            Financial_S_G_Profile.profiles.get(f_account_id).add(this);
        }
    }
}
