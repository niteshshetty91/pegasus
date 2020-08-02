package com.nitesh.spring.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitesh.spring.project.model.Expression;
import com.nitesh.spring.project.repository.ExpressionRepository;

@Service
public class ExpressionServiceImpl implements ExpressionService{

	@Autowired
	ExpressionRepository expressionRepository;

	@Override
	public List<Expression> findAll() {
		// TODO Auto-generated method stub
		return expressionRepository.findAll();
	}

	@Override
	public Expression save(Expression expression) {
		// TODO Auto-generated method stub
		return expressionRepository.save(expression);
	}

}
