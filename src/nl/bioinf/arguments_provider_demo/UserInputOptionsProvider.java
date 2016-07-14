/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package nl.bioinf.arguments_provider_demo;

/**
 * Interface specifies all properties an OptionsProvider should serve.
 * @author michiel
 */
public class UserInputOptionsProvider implements OptionsProvider{

    @Override
    public String getUserName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VerbosityLevel getVerbosityLevel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
