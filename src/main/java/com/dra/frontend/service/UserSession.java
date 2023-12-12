package com.dra.frontend.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope("singleton")
public class UserSession {
    private String username;
    private String token;
    private String email;
}
