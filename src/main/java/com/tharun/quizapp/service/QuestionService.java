package com.tharun.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tharun.quizapp.dao.QuestionDao;
import com.tharun.quizapp.model.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;
	
	//GET ALL QUESTIONS
	public ResponseEntity<List<Question>> getAllQuestions(){
		try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NO_CONTENT);
	}
	
	//GET QUESTIONS PER CATEGORY
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {//to send data with status code
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);//if there is a error this will be returned
	}
	
	
	//CRUDE OPERATIONS
	public ResponseEntity<String> addQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("successfully added",HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDao.delete(question);
		return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
	}
	public ResponseEntity<String> updateQuestion(Question question) {//similar to add by the present data is updated
		// TODO Auto-generated method stub
		questionDao.save(question);
		return new ResponseEntity<>("successfully updated",HttpStatus.CREATED);
	}

}
