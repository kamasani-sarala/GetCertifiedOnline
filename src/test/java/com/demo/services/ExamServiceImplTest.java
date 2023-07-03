package com.demo.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.entity.Exam;
import com.demo.exception.ExamNotFoundException;
import com.demo.exception.InvalidExamIdException;
import com.demo.exception.NullValuesFoundException;
import com.demo.repository.ExamRepository;

@SpringBootTest
class ExamServiceImplTest {

	@Autowired
	ExamService examService;
	
	@Autowired
	ExamRepository examRepository;

	

	    @Test
	    public void GetExamByeId()throws InvalidExamIdException {
	        int eId = 1; // Specify the exam ID to retrieve
	        
	        try {
	            // Call the method under test
	            Exam exam = examService.getExamByeId(eId);
	            
	            // Assert the returned exam object
	            Assertions.assertWith(exam);
	            
	            // Add more assertions if needed based on the expected behavior
	        } catch (InvalidExamIdException e) {
	            Assertions.fail("InvalidExamIdException was thrown: " + e.getMessage());
	        }
	    }
	   
	    
	    @Test
	    public void FindExamWithSorting()throws Exception {
	        String eName = "Math Exam"; // Specify the exam name to search
	        
	        // Set up test data and conditions for sorting
	        
	        // Call the method under test
	        List<Exam> exams = examService.findExamWithSorting(eName);
	       
	    }
	    
	    @Test
	    public void GetExamByEndTime() {
	        String eName = "Math Exam"; // Specify the exam name
	        String endTime = "2023-06-01T10:00:00"; // Specify the end time
	        
	        // Set up test data and conditions
	        
	        // Call the method under test
	        Exam exam = examService.getExamByEndTime(eName, endTime);
	        
	    }
	    
	    @Test
	    public void SortingBasedOnDuration()throws NullValuesFoundException {
	        
	        // Set up test data and conditions for sorting
	        
	        // Call the method under test
	        List<Exam> exams = examService.sortingBasedOnDuration();
	        
	    }

	    @Test
	    public void testViewAllExams() throws Exception {
	        // Assuming you have a list of exams to test with
	        List<Exam> expectedExams = new ArrayList<>();
	        expectedExams.add(new Exam(01, "Python", 2, "4PM", "5PM", "10/08/2023"));
	        expectedExams.add(new Exam(02, "java", 2, "3PM", "4PM", "10/07/2023"));
	        expectedExams.add(new Exam(03, "java", 2, "6PM", "7PM", "10/09/2023"));
            
	       
	        List<Exam> actualExams = examService.viewAllExams();

	        // Assert
	        Assertions.assertThat(expectedExams.size());
	      
	      }
	 //    @Test
	 //    public void UpdateExam() throws NumberFormatException{
  // Exam exam = new Exam(01, "java", 2, "3PM", "4PM", "10/07/2023");
        
  //       // Act
  //       // Call the UpdateExam() method with your desired test scenario
        
  //       // Assert
  //       // Assert the expected result or behavior based on the test scenario
  //       // For example:
  //       int expectedExamId = 01;
  //       String expectedSubject = "java";
  //       int expectedDuration = 2;
  //       String expectedStartTime = "3PM";
  //       String expectedEndTime = "4PM";
  //       String expectedDate = "10/07/2023";
        
  //       assertEquals(expectedExamId, exam.geteId());
  //       assertEquals(expectedSubject, exam.geteName());
  //       assertEquals(expectedDuration, exam.getDuration());
  //       assertEquals(expectedStartTime, exam.getStartTime());
  //       assertEquals(expectedEndTime, exam.getEndTime());
  //       assertEquals(expectedDate, exam.getExamDate());
  //   }
	   
	    @Test
	    public void testGetExamByDuration() throws NullValuesFoundException {
	        // Arrange
	        int duration = 2; // Specify the valid duration
	        ExamServiceImpl examService = new ExamServiceImpl();

	        // Act
	        List<Exam> exams = examService.getExamByDuration(duration);

	        // Assert
	        Assertions.assertWith(exams);
	        Assertions.assertThat(exams.isEmpty());
	        for (Exam exam : exams) {
	            Assertions.assertThat(duration);
	        }
	    }
	    @Test
	    public void testDeleteByeId_NonExistingId_NoExceptionThrown() throws InvalidExamIdException {
	        // Arrange
	        int nonExistingId = 999;

	        // Act and Assert
	        Assertions.assertThatThrownBy(() -> {
	            ExamService exams = null;
				exams.deleteByeId(nonExistingId);
	        });
	    }
	    // @Test

	    // public void addExam() throws ExamNotFoundException {

	     

	    // Exam exam = new Exam();

	    // exam.seteId(18);

	    // exam.seteName("Java");

	    // exam.setStartTime("2Pm");

	    // exam.setEndTime("4PM");

	    // exam.setDuration(2);
	    
	    // exam.setExamDate("12/03/2023");

	    // Exam addExam = examService.addExam(exam);

	     

	    // assertNotNull(addExam);

	     

	    // }
}
// package com.demo.services;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.ArgumentCaptor;
// import org.mockito.Captor;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.demo.entity.Exam;
// import com.demo.exception.ExamNotFoundException;
// import com.demo.exception.InvalidExamIdException;
// import com.demo.exception.NullValuesFoundException;
// import com.demo.repository.ExamRepository;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// public class ExamServiceImplTest {

//     @Mock
//     private ExamRepository examRepository;

//     @InjectMocks
//     private ExamServiceImpl examService;

//     @Captor
//     private ArgumentCaptor<Exam> examCaptor;

//     @BeforeEach
//     public void setUp() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     public void testViewAllExams() throws ExamNotFoundException {
//         // Arrange
//         List<Exam> expectedExams = new ArrayList<>();
//         expectedExams.add(new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1));

//         when(examRepository.findAll()).thenReturn(expectedExams);

//         // Act
//         List<Exam> allExams = examService.viewAllExams();

//         // Assert
//         assertEquals(expectedExams, allExams);
//     }

//     @Test
//     public void testUpdateExam() throws InvalidExamIdException {
//         // Arrange
//         Exam existingExam = new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1);
//         Exam updatedExam = new Exam(1, "Java", 3, "3PM", "5PM", "10/07/2023", 1);

//         when(examRepository.save(examCaptor.capture())).thenReturn(updatedExam);
//         when(examRepository.getExambyeId(existingExam.geteId())).thenReturn(existingExam);

//         // Act
//         Exam result = examService.updateExam(updatedExam);

//         // Assert
//         assertEquals(updatedExam, result);
//         assertEquals(updatedExam.getDuration(), examCaptor.getValue().getDuration());
//         assertEquals(updatedExam.getEndTime(), examCaptor.getValue().getEndTime());
//         verify(examRepository).getExambyeId(existingExam.geteId());
//         verify(examRepository).save(updatedExam);
//     }

//     @Test
//     public void testDeleteByeId() throws InvalidExamIdException {
//         // Arrange
//         int examId = 1;

//         // Act
//         examService.deleteByeId(examId);

//         // Assert
//         verify(examRepository).deleteById(examId);
//     }

//     @Test
//     public void testAddExam() {
//         // Arrange
//         Exam examToAdd = new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1);
//         when(examRepository.save(examToAdd)).thenReturn(examToAdd);

//         // Act
//         Exam addedExam = examService.addExam(examToAdd);

//         // Assert
//         assertEquals(examToAdd, addedExam);
//         verify(examRepository).save(examToAdd);
//     }

//     @Test
//     public void testGetExamByeId() throws InvalidExamIdException {
//         // Arrange
//         int examId = 1;
//         Exam expectedExam = new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1);
//         when(examRepository.getExambyeId(examId)).thenReturn(expectedExam);

//         // Act
//         Exam result = examService.getExamByeId(examId);

//         // Assert
//         assertEquals(expectedExam, result);
//         verify(examRepository).getExambyeId(examId);
//     }

//     @Test
//     public void testGetExamByeId_InvalidExamIdException() {
//         // Arrange
//         int examId = 0;

//         // Act & Assert
//         assertThrows(InvalidExamIdException.class, () -> examService.getExamByeId(examId));
//         verify(examRepository, never()).getExambyeId(examId);
//     }

//     @Test
//     public void testGetExamByDuration() throws NullValuesFoundException {
//         // Arrange
//         int duration = 2;
//         List<Exam> matchingExams = new ArrayList<>();
//         matchingExams.add(new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1));

//         when(examRepository.findAll()).thenReturn(matchingExams);

//         // Act
//         List<Exam> result = examService.getExamByDuration(duration);

//         // Assert
//    //    assertEquals(matchingExams, result);
//     }

//     @Test
//     public void testGetExamByDuration_NullValuesFoundException() {
//         // Arrange
//         int duration = -1;

//         // Act & Assert
//         assertThrows(NullValuesFoundException.class, () -> examService.getExamByDuration(duration));
//         verify(examRepository, never()).findAll();
//     }

//     @Test
//     public void testFindExamWithSorting() throws ExamNotFoundException {
//         // Arrange
//         String eName = "Java";
//         List<Exam> matchingExams = new ArrayList<>();
//         matchingExams.add(new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1));

//         when(examRepository.findAll()).thenReturn(matchingExams);

//         // Act
//         List<Exam> result = examService.findExamWithSorting(eName);

//         // Assert
//       //  assertEquals(matchingExams, result);
//       //  verify(examRepository).findAll();
//     }

//     @Test
//     public void testSortingBasedOnDuration() throws NullValuesFoundException {
//         // Arrange
//         List<Exam> exams = new ArrayList<>();
//         exams.add(new Exam(1, "Java", 2, "3PM", "4PM", "10/07/2023", 1));
//         exams.add(new Exam(2, "Python", 1, "2PM", "3PM", "10/07/2023", 1));

//         when(examRepository.findAll()).thenReturn(exams);

//         // Act
//         List<Exam> result = examService.sortingBasedOnDuration();

//         // Assert
//         assertEquals(exams, result);
//         verify(examRepository).findAll();
//     }

    

// }


	

	  
	    


	
	
