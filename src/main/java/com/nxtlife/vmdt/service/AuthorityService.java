package com.nxtlife.vmdt.service;



import com.nxtlife.vmdt.entity.user.Authority;
import com.nxtlife.vmdt.view.user.security.AuthorityResponse;
import com.nxtlife.vmdt.ex.*;

import java.util.List;

public interface AuthorityService {

	public void save(Authority authority);

	/**
	 * this method used to fetch authority using id
	 * 
	 * @param id
	 * @return <tt>Authority</tt>
	 * @throws NotFoundException
	 *             if authority not found
	 */
	public Authority findById(long id);

	/**
	 * this method used to fetch all authorities
	 * 
	 * @return list of <tt>AuthorityResponse</tt>
	 */
	public List<AuthorityResponse> getAllAuthorities();

	/**
	 * this method used to fetch all authorities by role
	 * 
	 * @param roleId
	 * @return list of <tt>AuthorityResponse</tt>
	 * @throws NotFoundException
	 *             if role id not found
	 */
	public List<AuthorityResponse> getAllAuthoritiesByRoleId(Long roleId);

}
