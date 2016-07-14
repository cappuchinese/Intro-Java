/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package nl.bioinf.arguments_provider_demo;

/**
 * Main class designed to work with user input provided standard CL arguments and parsed using Apache CLI.
 * Class is final because it is not designed for extension.
 * @author michiel
 */
public final class CommandLineArgsRunner {
    /**
     * private constructor because this class is not supposed to be instantiated.
     */
    private CommandLineArgsRunner() { }

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        OptionsProvider op = new ApacheCliOptionsProvider(args);
        MessagingController controller = new MessagingController(op);
        controller.start();
    }
}
