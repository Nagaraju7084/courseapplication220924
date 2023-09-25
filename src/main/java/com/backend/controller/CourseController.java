package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.Course;
import com.backend.service.CourseService;

@RestController
@RequestMapping("/courseapi")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	

	@GetMapping("/getName/{name}")
	public String getName(@PathVariable String name) {
		return name;
	}
	
	@PostMapping("/addName/{name}")
	public String addName(@PathVariable String name) {
		return name+" name posting from course controller";
	}
	
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses(){
		return courseService.getAllCourse();
	}
	
	@GetMapping("/getCourse/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(Integer.parseInt(courseId));
	}
	
	@PostMapping("/addCourse")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@PutMapping("/updateCourse/{courseId}")
	public Course addCourse(@RequestBody Course course, @PathVariable String courseId) {
		return courseService.updateCourse(Integer.parseInt(courseId), course);
	}
	
	@DeleteMapping("/deleteCourse/{courseId}")
	public Course deleteCourse(@PathVariable String courseId) {
		return courseService.deleteCourse(Integer.parseInt(courseId));
	}
}
