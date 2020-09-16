package com.nxtlife.vmdt.dao.jpa;


import com.nxtlife.vmdt.entity.oauth.OauthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthClientDetailsJpaDao extends JpaRepository<OauthClientDetails, String> {
	
	public OauthClientDetails findByClientId(String clientId);

}
