package com.quiz_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QService {
	
	@Autowired
	quizRepo  qr;
	
	private int num;
	
public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

public List<quiz_questions> getQuestions() {
	 return qr.findAll();
}

public List<quiz_questions> getquiz(Integer number, String category, String difficulty) {

	return qr.getByNumberCategoryDifficulty(number,category,difficulty);
	
	
	
}

public List<quiz_questions> getQ(Integer number, String category, String difficulty) {
	this.num=number;
	return  qr.getByNumberCategoryDifficulty(number, category, difficulty);
	
}



}
