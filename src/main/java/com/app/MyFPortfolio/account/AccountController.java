package com.app.MyFPortfolio.account;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

import javax.servlet.http.HttpServletRequest;

import com.app.MyFPortfolio.MongoCURD.Account.Account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class AccountController {

    @PostMapping("account/create")
    public boolean createAccount(@RequestBody(required = true) Account account, HttpServletRequest request) {

        return true;
    }

    @GetMapping("account/all")
    public ConcurrentMap<String, ArrayList<Account>> getAllAccounts() {
        return Account.accounts;
    }

    // @GetMapping("account/<id>")
    // public ConcurrentMap<String, ArrayList<Account>> getAccountByUserID(@RequestParam(required = true)String user_id){
        
    // }
}
