package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.Exam;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvalidExamIdException;
import com.demo.exception.NullValuesFoundException;

@Service
public interface ExamService {


	public Exam updateExam(Exam exam)throws InvalidExamIdException;
	public Exam addExam(Exam exam) throws ExamNotFoundException;

	public Exam getExamByeId(int eId) throws InvalidExamIdException;

	public List<Exam> getExamByDuration(int duration) throws NullValuesFoundException;


	public List<Exam> findExamWithSorting(String eName) throws Exception;


	public Exam getExamByEndTime(String eName, String endTime);

	public void deleteByeId(int eId) throws InvalidExamIdException;

	public List<Exam> viewAllExams() throws ExamNotFoundException;
	public List<Exam> sortingBasedOnDuration()throws NullValuesFoundException;
	
	
	
	
}
