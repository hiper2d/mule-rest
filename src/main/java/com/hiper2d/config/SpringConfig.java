package com.hiper2d.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.hiper2d.util.Packages;

@Configuration
@Import({JpaConfig.class})
@ComponentScan(basePackages = {Packages.REPOSIORIES, Packages.SERVICES, Packages.UTILS})
public class SpringConfig {
}
