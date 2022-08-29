package com.ctrl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.TodoDao;
import com.entities.Todo;

@Controller
public class HomeCtrl {

	 
	@Autowired
	TodoDao todoDao;
	
	
	@RequestMapping("/")
	public String home(Model m) {
		
		List<Todo> list= this.todoDao.getAll();
		m.addAttribute("todos", list);
		m.addAttribute("page", "home");
		return "home";
	}

	@RequestMapping("/add")
	public String addTodo(Model m) {

		Todo t = new Todo();
		m.addAttribute("page","add");
		m.addAttribute("todo",t);

		return "home";
	}

	@RequestMapping(value = "/saveTodo", method = RequestMethod.POST)
	public RedirectView saveTodo(@ModelAttribute("todo") Todo t, Model m,HttpServletRequest request) throws InterruptedException  {
		
	    m.addAttribute("page","home");
	    System.out.println(t);
		t.setTodoDate(new Date());
		this.todoDao.save(t);
		//m.addAttribute("msg", "successfully added...");
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");

 		return  redirectView;
	}
	
	//delete handler
	@RequestMapping("/delete/{todoId}")
	public RedirectView deleteTodo(@PathVariable("todoId") int todoId,HttpServletRequest request)  {
		this.todoDao.deleteTodo(todoId);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
 		return  redirectView;
	}
	
	//update handler
	@RequestMapping("/update/{todoId}")
	public String updateTodo(@PathVariable("todoId") int todoId,Model m)  {
		
		Todo t=this.todoDao.getTodo(todoId);
		m.addAttribute("t",t);
 		return "update";
	}
	
	@RequestMapping(value = "/updateTodo", method = RequestMethod.POST)
	public RedirectView updateTodos(@ModelAttribute("todo") Todo t, HttpServletRequest request) {
		
	    System.out.println(t);
	    this.todoDao.updateT(t);
		RedirectView redirectView= new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
 		return  redirectView;
	}

}
