package com.backend.service;

import java.util.List;

import com.backend.entities.Course;

public interface CourseService {
	List<Course> getAllCourse();
	Course getCourse(int courseId);
	Course addCourse(Course course);
	Course updateCourse(int courseId, Course course);
	Course deleteCourse(int courseId);
}
