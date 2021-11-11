package com.pps.config;

import com.pps.adapter.CourseJpaAdapter;
import com.pps.adapter.RegistrationJpaAdapter;
import com.pps.ports.incoming.CourseServicePort;
import com.pps.ports.incoming.RegistrationServicePort;
import com.pps.ports.outgoing.CoursePersistencePort;
import com.pps.ports.outgoing.RegistrationPersistencePort;
import com.pps.recommend.RecommendUtil;
import com.pps.service.CourseServiceImpl;
import com.pps.service.RegistrationServiceImpl;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.model.PreferenceArray;
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

    @Bean
    public RegistrationServicePort registrationServicePort() {
        return new RegistrationServiceImpl(registrationPersistencePort());
    }

    @Bean
    public RegistrationPersistencePort registrationPersistencePort() {
        return new RegistrationJpaAdapter();
    }


    @Bean
    public RecommendUtil recommendUtil() {
        return new RecommendUtil();
    }

}
