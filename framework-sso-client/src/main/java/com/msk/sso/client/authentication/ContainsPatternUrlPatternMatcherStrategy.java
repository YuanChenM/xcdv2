package com.msk.sso.client.authentication;

import org.jasig.cas.client.authentication.UrlPatternMatcherStrategy;

/**
 * Created by jackjiang on 16/8/4.
 */
public class ContainsPatternUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    @Override
    public boolean matches(String url) {
        return url.contains("api");
    }

    @Override
    public void setPattern(String pattern) {

    }
}
