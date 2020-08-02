package com.nitesh.spring.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nitesh.spring.project.model.Expression;

public interface ExpressionRepository extends JpaRepository<Expression, Integer> {
	
	List<Expression> findAll();
	
	Expression save(Expression policy);

	
}
