package com.nxtlife.vmdt.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class SuccessResponse {

	@Schema(description = "success status code", example = "200")
	private int status;
	@Schema(description = "success message", example = "Successfully submitted")
	private String message;

	@Schema(description = "remark will be used when we have to give warning after deletion")
	private String remark;

	public SuccessResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
