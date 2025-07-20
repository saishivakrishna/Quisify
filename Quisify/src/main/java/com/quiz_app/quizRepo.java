package com.quiz_app;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepo extends JpaRepository<quiz_questions,Integer> {

	
	@Query(value = "SELECT * FROM quiz_questions WHERE category = ?2 and difficulty = ?3 ORDER BY RAND() LIMIT ?1", nativeQuery = true)
	List<quiz_questions> getByNumberCategoryDifficulty(Integer number, String category, String difficulty);


	

}
