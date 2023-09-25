package com.backend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.backend.entities.Course;
import com.backend.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> courseList;
	
	public CourseServiceImpl() {
		courseList = new ArrayList<>();
		courseList.add(new Course(10, "java","java book"));
		courseList.add(new Course(20, "python","python book"));
	}

	@Override
	public List<Course> getAllCourse() {
		return courseList;
	}

	@Override
	public Course getCourse(int courseId) {
		Course course = null;
		for(Course c : courseList) {
			if(c.getId()==courseId) {
				course = c;
				break;
			}
		}
		return course;
	}

	@Override
	public Course addCourse(Course course) {
		courseList.add(course);
		return course;
	}

	@Override
	public Course updateCourse(int courseId, Course course) {
		AtomicReference<Course> updatedCourseRef = new AtomicReference<>();
		courseList.forEach(ce ->{
			if(ce.getId() == courseId) {
				ce.setTitle(course.getTitle());
				ce.setDescription(course.getDescription());
				updatedCourseRef.set(ce);
			}
		});
		return updatedCourseRef.get();
	}

	@Override
	public Course deleteCourse(int courseId) {
		Course deletingCourse = courseList.stream().filter(course -> course.getId() == courseId).findAny().get();
		courseList.removeIf(course -> course.getId() == deletingCourse.getId());
		return deletingCourse;
	}

}
