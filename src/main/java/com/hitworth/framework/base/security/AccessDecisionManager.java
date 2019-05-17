/**
 * 
 */
package com.hitworth.framework.base.security;

import org.apache.log4j.Logger;
/**
 * @author 徐泽宇(roamer)
 * 
 *         2010-7-4
 */
import java.util.Collection;
import java.util.Iterator;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service("hitworthAccessDecisionManager")
public class AccessDecisionManager
    implements
      org.springframework.security.access.AccessDecisionManager {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(AccessDecisionManager.class);

  // In this method, need to compare authentication with configAttributes.
  // 1, A object is a URL, a filter was find permission configuration by this
  // URL, and pass to here.
  // 2, Check authentication has attribute in permission configuration
  // (configAttributes)
  // 3, If not match corresponding authentication, throw a
  // AccessDeniedException.
  public void decide(Authentication authentication, Object object,
      Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
      InsufficientAuthenticationException {
    if (logger.isDebugEnabled()) {
      logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - start"); //$NON-NLS-1$
    }
    if (configAttributes == null) {
      return;
    }
    if (logger.isDebugEnabled()) {
      logger.debug("url:" + object.toString());
    }
    Iterator<ConfigAttribute> ite = configAttributes.iterator();
    while (ite.hasNext()) {
      ConfigAttribute ca = ite.next();
      String needRole = ((SecurityConfig) ca).getAttribute();
      for (GrantedAuthority ga : authentication.getAuthorities()) {
        if (needRole.equals(ga.getAuthority())) {
          return;
        }
      }
    }
    throw new AccessDeniedException("no role");
  }

  public boolean supports(ConfigAttribute attribute) {
    return true;
  }

  public boolean supports(Class<?> clazz) {
    return true;
  }
}
