package com.advancia.PiadineriaAdvanciaEJB.infrastructure.services.impl;

import javax.ejb.Stateless;

@Stateless
public class LoginServiceBean {
    public boolean isRemembered(Object rememberMe) {
        return "on".equals(rememberMe);
    }
}