package com.blog.dao;

import com.blog.entity.CredentialMaster;

public interface CredentialDao {

	
	Integer saveCridential(CredentialMaster cridentialMaster);
	
	CredentialMaster getUserName(String username);
	
	Integer update(CredentialMaster cridentialMaster);
	
	CredentialMaster getcredentialsByUser(Integer id);
}
