package com.pps.config;

import com.pps.adapter.CourseJpaAdapter;
import com.pps.ports.incoming.CourseServicePort;
import com.pps.ports.outgoing.CoursePersistencePort;
import com.pps.service.CourseServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CourseServicePort courseServicePort() {
        return new CourseServiceImpl(coursePersistencePort());
    }

    @Bean
    public CoursePersistencePort coursePersistencePort() {
        return new CourseJpaAdapter();
    }

}
