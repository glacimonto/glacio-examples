package com.github.fridujo.glacio.examples;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.fridujo.glacio.extension.spring.SpringExtension;
import com.github.fridujo.glacio.running.api.configuration.GlacioConfiguration;
import com.github.fridujo.glacio.running.api.extension.ExtendGlacioWith;

@GlacioConfiguration(
    featurePaths = "classpath:features",
    gluePaths = "com.github.fridujo.glacio.examples"
)
@ExtendGlacioWith(SpringExtension.class)
@SpringBootTest(classes = ApplicationBootstrap.class, properties = "spring.main.banner-mode=off")
@AutoConfigureMockMvc
public class GlacioTests {
}
