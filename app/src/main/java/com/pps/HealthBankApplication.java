package com.pps;

import com.pps.entity.Course;
import com.pps.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class HealthBankApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(HealthBankApplication.class);
    }

    @Override
    public void run(String... args) {
        Course build1 = Course.builder()
                .title("a")
                .description("haha")
                .limitCount(5)
                .build();
        Course build2 = Course.builder()
                .title("b")
                .description("haha")
                .limitCount(15)
                .build();
        Course build3 = Course.builder()
                .title("c")
                .description("haha")
                .limitCount(10)
                .build();

        courseRepository.save(build1);
        courseRepository.save(build2);
        courseRepository.save(build3);
    }

}
