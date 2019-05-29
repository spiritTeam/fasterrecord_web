package com.hitworth.framework.base.security;

import org.springframework.security.core.AuthenticationException;

public class CaFailException extends AuthenticationException {

	private static final long serialVersionUID = -3333012976129153127L;

	public CaFailException(String msg) {
		super(msg);

	}

}
