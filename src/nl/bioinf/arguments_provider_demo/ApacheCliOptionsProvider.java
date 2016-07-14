/*
 * Copyright (c) 2015 Michiel Noback
 * All rights reserved
 * www.bioinf.nl, www.cellingo.net
 */
package nl.bioinf.arguments_provider_demo;

import java.util.Arrays;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * This class implements the OptionsProvider interface by parsing the passed command line arguments.
 *
 * @author michiel
 */
public class ApacheCliOptionsProvider implements OptionsProvider {
    private static final String HELP = "help";
    private static final String NAME = "name";
    private static final String AGE = "age";
    private static final String VERBOSITY = "verbosity";

    private final String[] clArguments;
    private Options options;
    private CommandLine commandLine;
    private VerbosityLevel level;
    private int age;

    /**
     * constructs with the command line array.
     *
     * @param args the CL array
     */
    public ApacheCliOptionsProvider(final String[] args) {
        this.clArguments = args;
        initialize();
    }

    /**
     * Options initialization and processing.
     */
    private void initialize() {
        buildOptions();
        processCommandLine();
        checkHelpRequested();
    }

    /**
     * check if help was requested; if so, simply exit.
     */
    private void checkHelpRequested() {
        if (options.hasOption(HELP)) {
            printHelp();
            System.exit(0);
        }
    }

    /**
     * builds the Options object.
     */
    private void buildOptions() {
        // create Options object
        this.options = new Options();
        Option help = new Option("h", HELP, false, "Prints this message");
        Option name = new Option("n", NAME, true, "User name for this session; defaults to \"JohnDoe\"");
        Option age = new Option("a", AGE, true, "User age for intelligent feedback; defaults to 42");
        Option level = new Option("v", VERBOSITY, true, "Verbosity level; choose "
                        + "\n1: Quiet, or the strong silent type\n2: normal\n3: talk too much\nDefaults to normal");
        options.addOption(help);
        options.addOption(name);
        options.addOption(age);
        options.addOption(level);
    }

    /**
     * processes the command line arguments.
     */
    private void processCommandLine() {
        try {
            CommandLineParser parser = new DefaultParser();
            this.commandLine = parser.parse(this.options, this.clArguments);
            //set correct level
            if (commandLine.hasOption(VERBOSITY)) {
                try {
                    int levelindex = Integer.parseInt(commandLine.getOptionValue(VERBOSITY));
                    this.level = VerbosityLevel.values()[levelindex - 1];
                } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                    this.level = VerbosityLevel.NORMAL;
                }
            }
            //check correct age format
            String agestr = this.commandLine.getOptionValue(AGE, "42");
            this.age = Integer.parseInt(agestr);
        } catch (ParseException ex) {
            System.err.println("Something went wrong while processing your command line \""
                    + Arrays.toString(clArguments) + "\"");
            System.err.println("Parsing failed.  Reason: " + ex.getMessage());
            System.err.println("Correct usage:\n");
            printHelp();
        }
    }

    /**
     * prints help.
     */
    private void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("MyCoolTool", options);
    }

    @Override
    public String getUserName() {
        return this.commandLine.getOptionValue(NAME, "JohnDoe");
    }

    @Override
    public VerbosityLevel getVerbosityLevel() {
        return this.level;
    }

    @Override
    public int getUserAge() {
        return age;
    }

}
