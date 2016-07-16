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
    }

    /**
     * check if help was requested; if so, return true.
     * @return helpRequested
     */
    public boolean helpRequested() {
        return this.commandLine.hasOption(HELP);
    }

    /**
     * builds the Options object.
     */
    private void buildOptions() {
        // create Options object
        this.options = new Options();
        Option helpOption = new Option("h", HELP, false, "Prints this message");
        Option nameOption = new Option("n", NAME, true, "User name for this session; defaults to \"JohnDoe\"");
        Option ageOption = new Option("a", AGE, true, "User age for dedicated feedback; defaults to 42");
        Option levelOption = new Option("v", VERBOSITY, true, "Verbosity level; choose "
                        + "\n1: Quiet (or the strong silent type)\n2: normal\n3: talk too much\nDefaults to normal");
        options.addOption(helpOption);
        options.addOption(nameOption);
        options.addOption(ageOption);
        options.addOption(levelOption);
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
            } else {
                this.level = VerbosityLevel.NORMAL;
            }
            //check correct age format
            String agestr = this.commandLine.getOptionValue(AGE, "42");
            this.age = Integer.parseInt(agestr);
        } catch (ParseException ex) {
            throw new IllegalStateException(ex);
        }
    }

    /**
     * prints help.
     */
    public void printHelp() {
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
