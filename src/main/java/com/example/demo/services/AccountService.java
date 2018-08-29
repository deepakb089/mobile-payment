package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.models.Deposit;
import com.example.demo.models.Transfer;
import com.example.demo.entities.User;
import com.example.demo.repos.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    AccountRepo accountRepo;

    @Autowired
    UserServices userServices;


    public boolean create(User u) {
        Account a = new Account();
        a.setUserId(u.getId());
        a.setAmount(1);
        accountRepo.save(a);
        return true;
    }

    public boolean deposit(Deposit d) {
        User u = userServices.findByPhone(d.getPhone());
        Account account = accountRepo.findByUserId(u.getId());
        account.setAmount(account.getAmount() + d.getAmount());
        accountRepo.save(account);
        return true;
    }

    public boolean isPositive(Transfer t) {
        User u = userServices.findByPhone(t.getFromPhone());
        Account account = accountRepo.findByUserId(u.getId());
        if (account.getAmount() > t.getAmount()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(Transfer t) {
        User from = userServices.findByPhone(t.getFromPhone());
        User to = userServices.findByPhone(t.getToPhone());

        Account fromAcc = accountRepo.findByUserId(from.getId());
        Account toAcc = accountRepo.findByUserId(to.getId());

        double newFromAmt = fromAcc.getAmount() - t.getAmount();
        double newToAmt = toAcc.getAmount() + t.getAmount();

        fromAcc.setAmount(newFromAmt);
        toAcc.setAmount(newToAmt);

        accountRepo.save(fromAcc);
        accountRepo.save(toAcc);

        return true;
    }

}
