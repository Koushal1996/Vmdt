package com.nxtlife.vmdt.service.impl;
import com.nxtlife.vmdt.dao.jpa.OauthClientDetailsJpaDao;
import com.nxtlife.vmdt.entity.oauth.OauthClientDetails;
import com.nxtlife.vmdt.service.OauthClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("oauthClientService")
public class OauthClientServiceImpl implements OauthClientService {

	@Autowired
	private OauthClientDetailsJpaDao oauthClientDetailsDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {
		if (oauthClientDetailsDao.findByClientId("snomed") == null) {
			OauthClientDetails oauthClientDetails = new OauthClientDetails();
			oauthClientDetails.setAccessTokenValidity(-1);
			oauthClientDetails.setScope("read,write");
			oauthClientDetails.setClientId("snomed");
			oauthClientDetails.setAuthorizedGrantTypes("password");
			oauthClientDetails.setAutoapprove("1");
			oauthClientDetails.setClientSecret(passwordEncoder.encode("nxtlife"));
			oauthClientDetails.setRefreshTokenValidity(-1);
			oauthClientDetails.setResourceIds("vmdt-api");
			oauthClientDetailsDao.save(oauthClientDetails);
		}
	}

}
