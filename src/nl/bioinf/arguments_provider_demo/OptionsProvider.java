/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package nl.bioinf.arguments_provider_demo;

/**
 * interface that specifies which options should be provided to the tool.
 * @author michiel
 */
public interface OptionsProvider {
    String getUserName();
    VerbosityLevel getVerbosityLevel();
    int getUserAge();
}
