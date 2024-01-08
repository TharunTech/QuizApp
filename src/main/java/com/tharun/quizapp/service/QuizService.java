package com.tharun.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tharun.quizapp.QuestionWrapper;
import com.tharun.quizapp.dao.QuestionDao;
import com.tharun.quizapp.dao.QuizDao;
import com.tharun.quizapp.model.Question;
import com.tharun.quizapp.model.Quiz;
import com.tharun.quizapp.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {//To create a table of quiz based on the given category in the user URL
																						//2 new Tables are created to store the quiz values and the relation between quiz and question table
		
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
	
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		Integer quizid = quiz.getId();
		return new ResponseEntity<>("successfully created a quiz QuizId = "+quizid,HttpStatus.CREATED);
		
		
	}

	
	
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		
		List<QuestionWrapper> questionForUser = new ArrayList<>();
		
		for(Question q : questionsFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionForUser.add(qw);
		}
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}



	public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		
		int right =0;//if the answer is right this is incremented
		int i=0;
		for(Response response: responses) {
			
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;
			
			i++;
		}
		
		return new ResponseEntity<>("Your Total Score is : "+right,HttpStatus.OK);
		
	}


}
