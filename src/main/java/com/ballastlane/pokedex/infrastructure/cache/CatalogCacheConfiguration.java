package com.ballastlane.pokedex.infrastructure.cache;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** The catalog caches (stub). */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(CatalogCacheProperties.class)
public class CatalogCacheConfiguration {

  @Bean
  CacheManager cacheManager(CatalogCacheProperties properties) {
    return new CaffeineCacheManager();
  }
}
