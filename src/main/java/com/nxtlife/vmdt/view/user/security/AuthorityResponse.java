package com.nxtlife.vmdt.view.user.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.nxtlife.vmdt.entity.user.Authority;
import com.nxtlife.vmdt.view.Response;
import io.swagger.v3.oas.annotations.media.Schema;


@JsonInclude(value = Include.NON_ABSENT)
public class AuthorityResponse implements Response {

	@Schema(description = "Unique identifier of authority", example = "1")
	private Long id;

	@Schema(description = "Name of the authority", example = "AUTHORITY_FETCH")
	private String name;

	@Schema(description = "Group name of the authority", example = "AUTHORITY")
	private String groupName;

	@Schema(description = " Description of authority", example = "Access to fetch the authority", nullable = true)
	private String description;

	public AuthorityResponse() {
	}

	public AuthorityResponse(Authority authority) {
		if (authority != null) {
			this.id = authority.getId();
			this.name = authority.getName();
			this.description = authority.getDescription();
		}
	}

	public Long getId() {
		return mask(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
