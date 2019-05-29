package com.hitworth.framework.base.security.provider;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

import com.hitworth.framework.base.security.CaFailException;
import com.hitworth.framework.base.security.token.CaUsernamePasswordAuthenticationToken;
import com.hitworth.framework.base.util.MessageUtil;

public class CaAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {


  private UserDetailsService userDetailsService;

  // ========================================================================================================

  @Override
  protected void additionalAuthenticationChecks(UserDetails userDetails,
      UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    if (authentication.getCredentials() == null)
      throw new CaFailException(MessageUtil.get(10010 + ""));



    String presentedPassword = authentication.getCredentials().toString();

    String password =
        new Md5PasswordEncoder().encodePassword(presentedPassword, userDetails.getUsername());

    if (!password.equals(userDetails.getPassword()))
      throw new CaFailException(MessageUtil.get(10010 + ""));

    if (!userDetails.isEnabled()) throw new CaFailException(MessageUtil.get(10012 + ""));

    if (authentication instanceof CaUsernamePasswordAuthenticationToken) {

      CaUsernamePasswordAuthenticationToken ca =
          (CaUsernamePasswordAuthenticationToken) authentication;
      if (!ca.getPlainText().equals(ca.getSignature()))

      throw new CaFailException(MessageUtil.get(10011 + ""));

    }



  }

  protected void doAfterPropertiesSet() throws Exception {
    Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
  }

  protected final UserDetails retrieveUser(String username,
      UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    UserDetails loadedUser = userDetailsService.loadUserByUsername(username);

    if (loadedUser == null) {
      throw new CaFailException(MessageUtil.get(10010 + ""));
    }
    return loadedUser;
  }

  public UserDetailsService getUserDetailsService() {
    return userDetailsService;
  }

  public void setUserDetailsService(UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }


}
