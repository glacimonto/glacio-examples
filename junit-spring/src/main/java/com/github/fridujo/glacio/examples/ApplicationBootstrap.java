package com.github.fridujo.glacio.examples;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ApplicationBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationBootstrap.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }
}
