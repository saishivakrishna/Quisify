package com.quiz_app;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class qController {
	@Autowired
	QService service;
	@Autowired
	quizRepo qr;
	
	
@GetMapping("/home")	
public String mainPage() {
	return  "index";
	
}





}
