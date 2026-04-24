package com.eazybytes.jobportal.scopes;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Component
@SessionScope
@Getter
@Setter
public class SessionScopedBean {

    private String username;

    public SessionScopedBean() {
        System.out.println("SessionScopedBean created");
    }

}
