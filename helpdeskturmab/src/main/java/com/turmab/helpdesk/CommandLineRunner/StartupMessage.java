package com.turmab.helpdesk.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupMessage implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
    	System.out.println("********************************************");
    	System.out.println("* *");
        System.out.println("* Aplicação helpdesk iniciada com sucesso!   *");
        System.out.println("* *");
        System.out.println("********************************************");
    }
}