package com.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Todo;

@Component
public class TodoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly = false)
	public int save(Todo t) {
		Integer i= (Integer)this.hibernateTemplate.save(t);
		return i;
	}
	
	@Transactional(readOnly = false)
	public void updateT(Todo t) {
		  this.hibernateTemplate.update(t);
	 
	}
	
	public List<Todo> getAll(){
		List<Todo> todos= this.hibernateTemplate.loadAll(Todo.class);
		return todos;
	}
	
	@Transactional(readOnly = false)
	public void deleteTodo(int todoId) {
		Todo t=this.hibernateTemplate.load(Todo.class, todoId);
		this.hibernateTemplate.delete(t);
	}
	
	public Todo getTodo(int todoId) {
		return this.hibernateTemplate.get(Todo.class, todoId);
	}
	
	
}
