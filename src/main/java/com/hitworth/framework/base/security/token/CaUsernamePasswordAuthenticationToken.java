package com.hitworth.framework.base.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class CaUsernamePasswordAuthenticationToken extends
		UsernamePasswordAuthenticationToken {

  private  String signature;
  private  String plainText;
  
  
  private static final long serialVersionUID = -4431630924739692252L;

  public CaUsernamePasswordAuthenticationToken(String principal, String credentials,
			String signature, String plainText) {
		super(principal, credentials);
		this.signature = signature;
		this.plainText = plainText;
	}

  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getPlainText() {
    return plainText;
  }

  public void setPlainText(String plainText) {
    this.plainText = plainText;
  }


}
