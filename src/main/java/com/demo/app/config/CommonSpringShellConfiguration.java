package com.demo.app.config;

import com.demo.app.util.InputReader;
import com.demo.app.util.ShellHelper;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CommonSpringShellConfiguration {

    @Bean
    public ShellHelper helper(@Lazy Terminal terminal) {
        return new ShellHelper(terminal);
    }
    @Bean
    public InputReader inputReader(@Lazy LineReader lineReader) {
        return new InputReader(lineReader);
    }
}
