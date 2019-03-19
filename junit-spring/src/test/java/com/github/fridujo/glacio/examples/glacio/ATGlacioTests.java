package com.github.fridujo.glacio.examples.glacio;

import com.github.fridujo.glacio.running.api.configuration.GlacioConfiguration;

@GlacioConfiguration(
    featurePaths = "classpath:features",
    gluePaths = "com.github.fridujo.glacio.examples.glacio.stepdefs"
)
public class ATGlacioTests {
}
