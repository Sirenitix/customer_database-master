package com.suleevn.springboot.web.controller;

import com.suleevn.springboot.web.database.dbadd;
import com.suleevn.springboot.web.database.dbupdate;
import com.suleevn.springboot.web.model.Todo;
import com.suleevn.springboot.web.service.TodoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import static com.suleevn.springboot.web.database.database.indf;
import static com.suleevn.springboot.web.database.database.user;
import static com.suleevn.springboot.web.service.TodoService.todos;

@Controller
public class TodoController {
	public static int idUpd;

	public static String fullNameAdd;
	public static Integer iinAdd;
	public static String passportAdd;
	public static String dateAdd;
	public static String discAdd;
	public static String addInfoAdd;
	public static String addressAdd;
	public static Integer phoneNumberAdd;
	public static String propAdd;
	public static String userAdd;

	public static String fullNameUpd;
	public static Integer iinUpd;
	public static String passportUpd;
	public static String dateUpd;
	public static String discUpd;
	public static String addInfoUpd;
	public static String addressUpd;
	public static Integer phoneNumberUpd;
	public static String propUpd;
	public static String userUpd;


	Logger logger = LoggerFactory.getLogger(TodoController.class);

	@Autowired
	TodoService service;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
		logger.info("todos?:" + todos);
		logger.info("idCounter?:" + indf);
		todos.clear();
		service.refresh();
		String name = getLoggedInUserName(model);
		model.put("todos", service.retrieveTodos(name));
		model.addAttribute("todo", new Todo());
		return "list-todos";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "", 0, "",   "", "", "", "",  0, ""));
		return "todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {

		if(id==0) {
			throw new RuntimeException("Something went wrong");
		}
		service.deleteTodo(id);
		service.refresh();
		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/show-todo", method = RequestMethod.GET)
	public String showTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "details";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo,
			BindingResult result) {

		if (result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		model.put("todo", todo);
		service.updateTodo(todo);
		idUpd = todo.getId();
		fullNameUpd = todo.getFullName();
		iinUpd = todo.getIin();
		passportUpd = todo.getPassport();
		dateUpd = todo.getDate();
		discUpd = todo.getDisc();
		addInfoUpd = todo.getAdd_inf();
		addressUpd = todo.getAddress();
		phoneNumberUpd = todo.getPhoneNumber();
		propUpd = todo.getProp();
		dbupdate.main(null);

		return "redirect:/list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		fullNameAdd = todo.getFullName();
		iinAdd = todo.getIin();
		passportAdd = todo.getPassport();
		dateAdd = todo.getDate();
		discAdd = todo.getDisc();
		addInfoAdd = todo.getAdd_inf();
		addressAdd = todo.getAddress();
		phoneNumberAdd = todo.getPhoneNumber();
		propAdd = todo.getProp();
		userAdd = userDetails.getUsername();
		dbadd.main(null);
		service.addTodo(getLoggedInUserName(model), todo.getFullName(), todo.getIin(),todo.getPassport(), todo.getDate(), todo.getDisc(),todo.getAdd_inf(), todo.getAddress(), todo.getPhoneNumber(), todo.getProp());

		return "redirect:/list-todos";

	}


	@RequestMapping(value = "/search-todo", method = RequestMethod.POST)
	public String showTitlePage(@ModelAttribute Todo todo, ModelMap model) {
		logger.info("title:" + todo.getFullName());
		String findTitle = todo.getFullName();
		service.searchTodo(findTitle);
		model.put("todos" , todos);
		return "list-todos";
	}

	@RequestMapping(value = "/sort-todo", method = RequestMethod.POST)
	public String showSortesTodos(@ModelAttribute Todo todo, ModelMap model) {
		String selCol = todo.getProp();
		service.sortTodo(selCol);
		model.put("todos" , todos);
		return "list-todos";
	}


}
