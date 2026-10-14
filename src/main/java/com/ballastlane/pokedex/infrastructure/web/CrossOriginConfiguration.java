package com.ballastlane.pokedex.infrastructure.web;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** Cross-origin (CORS) policy for the API (stub: registers nothing yet). */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CorsProperties.class)
public class CrossOriginConfiguration {}
