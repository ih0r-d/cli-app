package com.demo.app.command;

import com.demo.app.util.ShellHelper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class EchoCommand {

    private final ShellHelper helper;

    public EchoCommand(ShellHelper helper) {
        this.helper = helper;
    }

    @ShellMethod("Displays greeting message to the user whose name is supplied")
    public String echo(@ShellOption({"-N", "--name"}) String name) {

        return helper.getSuccessMessage(String.format("Hello %s!", name))
                     .concat("Congratulations with your first spring shell cli-app.");
    }

}
