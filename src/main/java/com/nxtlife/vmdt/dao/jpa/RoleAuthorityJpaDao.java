package com.nxtlife.vmdt.dao.jpa;


import com.nxtlife.vmdt.entity.common.RoleAuthorityKey;
import com.nxtlife.vmdt.entity.user.RoleAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleAuthorityJpaDao extends JpaRepository<RoleAuthority, RoleAuthorityKey> {

	public List<RoleAuthority> findAllByRoleId(Long roleId);

	@Query(value = "select authority_id from role_authority where role_id = ?1", nativeQuery = true)
	public List<Long> getAllAuthorityIdsByRoleId(Long roleId);

	@Modifying
	@Query(value="delete from role_authority where role_id=?1 and authority_id=?2", nativeQuery = true)
	public int deleteByRoleIdAndAuthorityId(Long roleId, Long authorityId);

	@Modifying
	@Query(value="delete from role_authority where role_id=?1 and authority_id in ?2", nativeQuery = true)
	public int deleteByRoleIdAndAuthorityIds(Long roleId, List<Long> authorityIds);

	@Modifying
	@Query(value="delete from role_authority where role_id=?1", nativeQuery = true)
	public int deleteByRoleId(Long roleId);

}
