package com.co.alaorden.util.pojo;

import com.co.alaorden.model.AccountEntity;
import com.co.alaorden.model.UserEntity;

public class UserRegister {
	UserEntity user;
	AccountEntity account;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserRegister{" +
				"user=" + user.toString() +
				", account=" + account.toString() +
				'}';
	}
}
