package com.demo.app.command;

import com.demo.app.model.User;
import com.demo.app.sevice.UserService;
import com.demo.app.util.InputReader;
import com.demo.app.util.ShellHelper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.util.StringUtils;

@ShellComponent
public class UserCommand implements MessageConstants {
    private final UserService userService;
    private final ShellHelper helper;
    private final InputReader reader;


    public UserCommand(UserService userService, ShellHelper helper, InputReader reader) {
        this.userService = userService;
        this.helper = helper;
        this.reader = reader;
    }

    @ShellMethod("Create new user with username.")
    public void createUser(@ShellOption({"-U", "--username"}) String username) {
        if (userService.exists(username)) {
            helper.printError(String.format(ERROR_MSG, username));
            return;
        }
        User user = new User();
        user.setUsername(username);
        do {
            String fullName = reader.prompt("Full name");
            if (StringUtils.hasText(fullName)) {
                user.setFullName(fullName);
            } else {
                helper.printWarning(String.format(WARNING_MSG, "User's full name"));
            }
        } while (user.getFullName() == null);
        do {
            String password = reader.prompt("Password", "secret", false);
            if (StringUtils.hasText(password)) {
                user.setPassword(password);
            } else {
                helper.printWarning(String.format(WARNING_MSG, "Password"));
            }
        } while (user.getPassword() == null);


        helper.printInfo("\nCreating new user:");
        helper.printDefault("\nUsername: " + user.getUsername());
        helper.printDefault("Password: " + user.getPassword());
        helper.printDefault("Fullname: " + user.getFullName());
        helper.printDefault("Superuser: " + user.isSuperuser() + "\n");

        User createdUser = userService.create(user);
        helper.printSuccess("Created user with id=" + createdUser.getId());

    }
}
