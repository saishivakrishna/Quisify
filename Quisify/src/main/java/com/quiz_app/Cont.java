package com.quiz_app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Cont {
    @Autowired
    quizRepo qr;
    @Autowired
    QService qs;

    @GetMapping("/generate-quiz")
    public String generateQuiz(
        @RequestParam Integer number,
        @RequestParam String category,
        @RequestParam String difficulty,Model model) {
    	
        
        List<quiz_questions> generatedQuizz=qs.getQ(number,category,difficulty);
        		
        model.addAttribute("quiz",generatedQuizz);
        return "quiz";
    }
    
    @GetMapping("/score")
    public String showScore(@RequestParam Map<String,String> answers, Model model) {
    	List<Integer> ids=new ArrayList<>();
    	answers.forEach((id,value)->ids.add(Integer.parseInt(id)));
    	
    	List<quiz_questions> questions=qr.findAllById(ids);
    	int number=qs.getNum();
    	int score=0;
    	String quote=null;
    	for(quiz_questions q:questions) {
    		String selectedAnswer=answers.get(String.valueOf(q.getId()));
    		if(selectedAnswer != null && selectedAnswer.equals(q.getAnswer())) {
    			score++;
    		}
    	}
    	if(score <number/2) {
    		quote="dude don't worry, practice makes man perfect";
    	}
    	else if(score > number/2 && score < number-10) {
    		quote="score is ok , but you should be pro dude ";
    	}
    	else if(score >number- 10 && score <=number) {
    		quote="dude your pro";
    	}
    	model.addAttribute("score",score);
    	model.addAttribute("number",number);
    	model.addAttribute("quote", quote);
    	return "score";
    }

}
