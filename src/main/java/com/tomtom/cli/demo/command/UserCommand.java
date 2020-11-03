package com.tomtom.cli.demo.command;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.tomtom.cli.demo.shell.ShellHelper;

@ShellComponent
public class UserCommand {

    @Autowired
    ShellHelper shellHelper;

    @ShellMethod("Print the text passed as a parameter on to standard console")
    public String print(@ShellOption({"-N", "--msg"}) String msg) {
        String message = String.format("%s", msg);
        return shellHelper.getSuccessMessage(message);
    }
    
    @ShellMethod("Displays current time")
    public String time() {
    	String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("KK:mm:ss a", Locale.ENGLISH));
        String message = String.format("%s", time);
        return shellHelper.getSuccessMessage(message);
    }
    
    @ShellMethod("Displays current date")
    public String date() {
    	String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-uuuu", Locale.ENGLISH));
        String message = String.format("%s", date);
        return shellHelper.getSuccessMessage(message);
    }
   
    //Please note Exit/ Quit are default commands
    
    
}
