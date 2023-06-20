package com.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Exam;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvalidExamIdException;
import com.demo.exception.NullValuesFoundException;
import com.demo.repository.ExamRepository;
import com.demo.sorting.SortingBasedOnDuration;


import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class ExamServiceImpl implements ExamService{
 
	@Autowired
	ExamRepository examRepository;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public List<Exam> viewAllExams() throws ExamNotFoundException{
		// TODO Auto-generated method stub
		List<Exam> allExam = examRepository.findAll(); // Note : same as save
		return allExam;
		
	}

	@Override
	public Exam updateExam(Exam exam)throws NumberFormatException {
		// TODO Auto-generated method stub
	
		Exam e = exam;
		try {
			e = getExamByeId(exam.geteId());
		} catch (InvalidExamIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        if (e== null) {
            throw new NumberFormatException("No Exam Exits with same this eid: " + exam.geteId());
        }

 

        return examRepository.save(exam);
    }
	

	@Override
	public void deleteByeId(int eId)throws InvalidExamIdException {
	// TODO Auto-generated method stub
		examRepository.deleteById(eId);
	}
		

	@Override
	public Exam addExam(Exam exams) throws NumberFormatException {
		// TODO Auto-generated method stub
		return examRepository.save(exams);
		
        
	}

	

	@Override
	public Exam getExamByeId(int eId) throws InvalidExamIdException {
		// TODO Auto-generated method stub
		if(eId == 0) {
			throw new InvalidExamIdException("invalid examId is not excepted");
		}
		
		return examRepository.getExambyeId(eId) ;
	}
	

	@Override
	public List<Exam> getExamByDuration(int duration) throws NullValuesFoundException{
//		// TODO Auto-generated method stub
		if (duration <= 0) {
            throw new NullValuesFoundException("Duration must be a positive integer.");
        }
        
        List<Exam> matchingExams = new ArrayList<>();

        for (Exam exam : matchingExams) {
            if (exam.getDuration() == duration) {
                matchingExams.add(exam);
            }
        }

        return matchingExams;
   
	}
	

	private List<Exam> getAllExams() {
	    // Replace this with your actual implementation to fetch all exams from a repository or service
	    List<Exam> allExams = new ArrayList<>();
	    // Add your logic to fetch exams and populate the allExams list
	    return allExams;
	}
		

	
	public Exam getExamByEndTime(String eName, String endTime) {
		
		List<Exam> Exams = new ArrayList<>();
        for (Exam exam : Exams) {
            if (exam.geteName().equals(eName) && exam.getEndTime().equals(endTime)) {
                return exam;
            }
        }
        return null; 
	}
	
	@Override
	public List<Exam> findExamWithSorting(String eName)throws Exception {
		// TODO Auto-generated method stub
		List<Exam> matchingExams = new ArrayList<>();

        // Find exams with matching name
        for (Exam exam :matchingExams) {
            if (exam.geteName().equals(eName)) {
                matchingExams.add(exam);
            }
        }

        // Sort exams based on start time
        Collections.sort(matchingExams, new Comparator<Exam>() {
            @Override
            public int compare(Exam exam1, Exam exam2) {
                return exam1.getStartTime().compareTo(exam2.getStartTime());
            }
        });

        return matchingExams;
	}

	@Override
	public List<Exam> sortingBasedOnDuration() throws NullValuesFoundException{
		List<Exam> list = examRepository.findAll();

		List<Exam> exams = new ArrayList<>();

		Collections.sort(list, new SortingBasedOnDuration());

		return list;
	       
	}
	

	


	
}	

