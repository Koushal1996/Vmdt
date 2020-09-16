package com.nxtlife.vmdt.dao.jpa;

import com.nxtlife.vmdt.entity.user.Authority;
import com.nxtlife.vmdt.view.user.security.AuthorityResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityJpaDao extends JpaRepository<Authority, Long> {
	
	public Boolean existsByName(String name);
	
	public AuthorityResponse findResponseById(Long id);
	
	public List<AuthorityResponse> findByAuthorityRolesRoleId(Long roleId);

	@Query(value="select id from Authority")
	public List<Long> findAllIds();


}
