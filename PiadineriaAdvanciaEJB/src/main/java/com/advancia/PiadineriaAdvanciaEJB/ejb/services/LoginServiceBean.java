package com.advancia.PiadineriaAdvanciaEJB.ejb.services;

import javax.ejb.Stateless;

@Stateless
public class LoginServiceBean {
    public boolean isRemembered(Object rememberMe) {
        return "on".equals(rememberMe);
    }
}