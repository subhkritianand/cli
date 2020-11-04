package com.tomtom.cli.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tomtom.cli.demo.command.UserCommand;
import com.tomtom.cli.demo.shell.PromptColor;
import com.tomtom.cli.demo.shell.ShellHelper;

@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext
class DemoApplicationTests {

	@Autowired
    private UserCommand userCommand;
	
	@Autowired
    private ShellHelper shellHelper;
	
	@Test
    void testApplicationStartup() {
        assertEquals("message", userCommand.print("message"));
        assertEquals(shellHelper.getColored("message", PromptColor.CYAN),
        		userCommand.print("message"));
        assertNotNull(userCommand.date());
    }

}
