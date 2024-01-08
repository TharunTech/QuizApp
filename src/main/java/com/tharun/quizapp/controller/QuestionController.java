package com.tharun.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tharun.quizapp.model.Question;
import com.tharun.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	
	//GET ALL QUESTIONS
	@GetMapping("allQuestions")//to get all questions
	public ResponseEntity<List<Question>> getAllQuestions() {

		return questionService.getAllQuestions();
	}

	
	//GET QUESTIONS PER CATEGORY
	@GetMapping("category/{category}")//search by category
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {// URL sent data will be stored in
																					// category variable
		return questionService.getQuestionsByCategory(category);
	}
	
	
	
	//CRUDE OPERATIONS
	@PostMapping("add")//to add new question - question data sent throught jSON Body
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@DeleteMapping("delete")//to delete question - question data sent throught jSON Body
	public ResponseEntity<String> deleteQuestion(@RequestBody Question question) {
		return questionService.deleteQuestion(question);
	}
	
	@PutMapping("update")//to update question - question data sent throught jSON Body
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
}
