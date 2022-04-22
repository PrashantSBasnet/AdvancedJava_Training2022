package com.cotiviti.sb.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StudentController {

	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("/index")
	public ModelAndView bank() {
		List<Student> list = new ArrayList<>();
		ModelAndView mv = new ModelAndView("form");
		mv.addObject("list", list); 
		return mv;
	}

	@GetMapping("/student-1")
	public ModelAndView students1() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Kshitiz", "Kathmandu", "kshitiz@gmail.com"));
		list.add(new Student("Sijan", "Kathmandu", "sijan@gmail.com"));
		list.add(new Student("Aman", "Kathmandu", "aman@gmail.com"));
		list.add(new Student("Abhishek", "Kathmandu", "abhishek@gmail.com"));
		ModelAndView mv = new ModelAndView("students"); // view=> jsp file that shows data
		mv.addObject("list", list); // list=>model because holds data
		return mv;
	}

	@GetMapping("/student-2")
	public String students2(Model model) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Riwaj", "Kathmandu", "kshitiz@gmail.com"));
		list.add(new Student("Prithu", "Kathmandu", "sijan@gmail.com"));
		list.add(new Student("Sanket", "Kathmandu", "aman@gmail.com"));
		list.add(new Student("Prashant", "Kathmandu", "abhishek@gmail.com"));
		list.add(new Student("Bishal", "Kathmandu", "abhishek@gmail.com"));
		model.addAttribute("list", list);
		String[] allBeanNames = applicationContext.getBeanDefinitionNames(); // this is to check all the beans in the
																				// ApplicationContext
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
		return "students";
	}

	

}
