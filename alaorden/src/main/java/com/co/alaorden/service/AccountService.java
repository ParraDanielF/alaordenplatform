package com.co.alaorden.service;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AccountService {
    private static Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    AccountRepository accountRepository;

    public AccountEntity create(AccountEntity account){
        return accountRepository.save(account);
    }

    public AccountEntity read(Integer id){
        return accountRepository.findById(id).get();
    }
    
    public Boolean validateCredentials(AccountEntity account){
    	logger.info(account.getEmail() + " " + account.getPassword());
    	String email = account.getEmail();
    	AccountEntity accountData = accountRepository.findByEmail(email).get();
    	logger.info("[RESPONSE]" + accountData);
    	if(accountData != null) {
    		return account.getPassword().equals(accountData.getPassword());
    	}else {
    		return false;
    	}
    	
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
