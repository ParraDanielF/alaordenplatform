package com.co.alaorden.service;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServices {
    @Autowired
    AccountRepository accountRepository;

    public AccountEntity create(AccountEntity account){
        return accountRepository.save(account);
    }

    public AccountEntity read(Integer id){
        return accountRepository.findById(id).get();
    }

    public AccountEntity update(AccountEntity account, Integer id){
        AccountEntity tmpAccount = accountRepository.findById(id).get();
        tmpAccount.setEmail(account.getEmail());
        tmpAccount.setPassword(account.getPassword());
        tmpAccount.setRoleId(account.getRoleId());
        tmpAccount.setStatus(account.getStatus());
        tmpAccount.setUserId(account.getUserId());
        return accountRepository.save(tmpAccount);
    }

    public String delete(Integer id){
        accountRepository.deleteById(id);
        return accountRepository.findById(id).get() == null ?
                "Eliminada la cuenta "+ id.toString() :
                "No se elimino la cuenta " + id.toString() ;
    }

}
