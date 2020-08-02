package com.nitesh.spring.project.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nitesh.spring.project.model.Expression;

public interface ExpressionService{
	
	List<Expression> findAll();
	
	Expression save(Expression policy);
	
}
