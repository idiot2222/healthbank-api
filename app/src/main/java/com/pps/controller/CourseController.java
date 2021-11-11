package com.pps.controller;

import com.pps.data.CourseDto;
import com.pps.data.EvaluationDto;
import com.pps.data.RegistrationDto;
import com.pps.entity.Registration;
import com.pps.ports.incoming.CourseServicePort;
import com.pps.ports.incoming.EvaluationServicePort;
import com.pps.ports.incoming.RegistrationServicePort;
import com.pps.recommend.RecommendUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.SeparatorUI;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServicePort courseServicePort;
    private final RegistrationServicePort registrationServicePort;
    private final EvaluationServicePort evaluationServicePort;

    private final RecommendUtil recommendUtil;

    @PostMapping("/create")
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseServicePort.createCourse(courseDto);
    }

    @GetMapping("/info/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseServicePort.getCourseById(id);
    }

    @GetMapping("/list")
    public List<CourseDto> getCourseList() {
        return courseServicePort.getAllCourseList();
    }

    @PutMapping("/update/{id}")
    public void updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
        CourseDto course = courseServicePort.getCourseById(id);
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setLimitCount(courseDto.getLimitCount());
        course.setTrainerId(courseDto.getTrainerId());

        courseServicePort.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseServicePort.deleteCourse(id);
    }

    @PostMapping("/register/{courseId}/{userId}")
    public void registerCourse(@PathVariable Long courseId, @PathVariable Long userId) {
        RegistrationDto dto = RegistrationDto.builder()
                .courseId(courseId)
                .userId(userId)
                .build();

        registrationServicePort.registerUser(dto);
    }

    @PostMapping("/unregister/{courseId}/{userId}")
    public void unregisterCourse(@PathVariable Long courseId, @PathVariable Long userId) {
        Registration registration = (Registration) registrationServicePort.findByRegistrationByCourseIdAndUserId(courseId, userId);

        registrationServicePort.unregisterUser(registration.convertToRegistrationDto());
    }



    //TODO
    //Recommend Add를 해야하는데 그 때마다 RecommendUtil의 map에 그 Evaluation을 저장해줄 것.
    // 근데 메모리에 계속 올려두고 운영하는 것도 에바쎄바니까 그냥 할 때마다 불러오는 걸로..

    @GetMapping("/recommendation/{userId}")
    public List<CourseDto> getRecommendedList(@PathVariable Long userId) {
        List<EvaluationDto> evaluations = evaluationServicePort.getAllEvaluations();

        return recommendUtil.recommend(userId, 5, evaluations)
                .stream()
                .map(courseServicePort::getCourseById)
                .collect(Collectors.toList());
    }
}
