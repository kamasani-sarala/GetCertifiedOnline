package com.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Exam;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvalidExamIdException;
import com.demo.exception.NullValuesFoundException;
import com.demo.services.ExamService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/Exam")
public class ExamController {
	
		@Autowired
		ExamService examService;
		
		private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
		
		@GetMapping("/")
		public String defaultMessage() {
			return "Welcome to Exam Page";
		}
		
		
		//http://localhost:8089/Exam/registerExam
		@PostMapping("/registerExam")
		public Exam addExam(@RequestBody Exam exam)  {
			try {
				return examService.addExam(exam);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return exam;
		}
		//http://localhost:8089/Exam/allExam
		@GetMapping("/allExam")
		public List<Exam> viewAllExam() throws Exception{
		return examService.viewAllExams();
		    }

		
		//http://localhost:8089/Exam/updateExam
		@PutMapping("/updateExam")
		public Exam updateExam(@RequestBody Exam exam) throws ExamNotFoundException{
			try {
		        Exam existingExam = examService.getExamByeId(exam.geteId());
		        if (existingExam == null) {
		            throw new ExamNotFoundException("Exam not found");
		        }
		       
		        // Update the properties of the existing exam
		        existingExam.seteName(exam.geteName());
		        existingExam.setStartTime(exam.getStartTime());
		        existingExam.setEndTime(exam.getEndTime());
		        existingExam.setDuration(exam.getDuration());
		        existingExam.setExamDate(exam.getExamDate());

		        // Call the updateExam() method from the examService to save the changes
		        Exam updatedExam = examService.updateExam(existingExam);
		        
		        return updatedExam;
		    } catch (InvalidExamIdException e) {
		        e.printStackTrace();
		        throw new ExamNotFoundException("Exam not found");
		    }
		}
		//http://localhost:8089/Exam/delete/3
		@DeleteMapping("/delete/{eId}") 

		public String deleteExam(@PathVariable int eId) throws NullValuesFoundException {
		try {

		examService.deleteByeId(eId);
		} catch (Exception e) {
		e.printStackTrace();

		}
		mylogs.info("Deleted = " + eId + " Data");
		return "Deleted Id = " + eId + " Data";

		}
		// localhost:8089/Exam/sort/duration
		@GetMapping("/sort/duration") 
		public List<Exam> getBySorting() throws NullValuesFoundException {

		List<Exam> allExam = examService.sortingBasedOnDuration();

		return allExam;

	}
	}

