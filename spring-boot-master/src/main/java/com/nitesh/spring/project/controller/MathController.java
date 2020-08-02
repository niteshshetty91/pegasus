package com.nitesh.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitesh.spring.project.model.Expression;
import com.nitesh.spring.project.repository.ExpressionRepository;
import com.nitesh.spring.project.service.ExpressionService;
import com.nitesh.spring.project.util.MathUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@RequestMapping("/solution")
@Controller
public class MathController {

	@Autowired
	ExpressionService expressionService;

	@RequestMapping("/showForm")
	public String showExpression(Model model) {

		Expression expression = new Expression();
		model.addAttribute("expression", expression);

		List<Expression> list = expressionService.findAll();

		Comparator<Expression> c = (s1,s2)->{ 

			if(s1.getExpressionId()<s2.getExpressionId()) {
				return 1;
			}else if(s1.getExpressionId()==s2.getExpressionId()) {
				return 0;
			}else {
				return -1;
			}

		};

		list = list.stream().sorted(c).collect(Collectors.toList());

		model.addAttribute("list", list);

		return "form";
	}

	@RequestMapping("/submitForm")
	public String submitForm(Model model,@ModelAttribute Expression expression) {

		String answer = MathUtil.evaluate(expression.getExpressionQuestion());

		expression.setExpressionAnswer(answer);

		expressionService.save(expression);
		model.addAttribute("expression", expression);


		List<Expression> list = expressionService.findAll();

		Comparator<Expression> c = (s1,s2)->{ 

			if(s1.getExpressionId()<s2.getExpressionId()) {
				return 1;
			}else if(s1.getExpressionId()==s2.getExpressionId()) {
				return 0;
			}else {
				return -1;
			}

		};

		list = list.stream().sorted(c).collect(Collectors.toList());

		model.addAttribute("list", list);

		return "form";
	}

	//////////////////////////  Demostrate the use of checkbox /////////////////////////////////////////////

	@RequestMapping("/testInput")
	public String expectForm(Model model,@ModelAttribute Expression expression) {


		return "";
	}	

	@RequestMapping("/submitInput")
	public String submitInput(Model model,@ModelAttribute Expression expression) {


		return "";
	}	



	////////////////////////////////////////////////////////////////////////////////////////////////////////

}
