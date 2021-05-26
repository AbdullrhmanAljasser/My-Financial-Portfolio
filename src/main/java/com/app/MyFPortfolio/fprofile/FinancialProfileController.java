package com.app.MyFPortfolio.fprofile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;

import com.app.MyFPortfolio.MongoCURD.Financial.Financial_S_G_Profile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class FinancialProfileController {
    
    @GetMapping(path = "/finnacial/profiles")
    public ConcurrentMap<String, ArrayList<Financial_S_G_Profile>> getProfilesByAccountId (String f_account_id, HttpServletRequest request){
        return Financial_S_G_Profile.profiles;
    }

    @PostMapping(path = "/finnancial/create")
    public boolean postProfile(@RequestBody(required = true) Financial_S_G_Profile fprofile, HttpServletRequest request){
        

        return true;
    }
}