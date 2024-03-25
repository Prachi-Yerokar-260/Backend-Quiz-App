package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Question;
import com.example.demo.dao.QuestionDao;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questiondao;
	
	public ResponseEntity<List<Question>> getAllQuestions(){
	try {
		return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);} 
	catch(Exception e) 
		{// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return new ResponseEntity<>(questiondao.findAll(), HttpStatus.BAD_REQUEST);
	}  

	
	public ResponseEntity< List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
			return new ResponseEntity<>( questiondao.findByCategory(category),HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>( questiondao.findByCategory(category),HttpStatus.OK);
	}

	public ResponseEntity< String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
			questiondao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		questiondao.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
}
