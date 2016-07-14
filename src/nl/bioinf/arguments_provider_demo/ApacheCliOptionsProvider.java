/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package nl.bioinf.arguments_provider_demo;

/**
 *
 * @author michiel
 */
public class ApacheCliOptionsProvider implements OptionsProvider{

    public ApacheCliOptionsProvider(String[] args) {
        
    }

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
