package com.suleevn.springboot.web.service;

import com.suleevn.springboot.web.database.database;
import com.suleevn.springboot.web.database.dbdelete;
import com.suleevn.springboot.web.database.dbsearch;
import com.suleevn.springboot.web.database.dbsorting;
import com.suleevn.springboot.web.model.Todo;
import com.suleevn.springboot.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.suleevn.springboot.web.database.database.*;


@Service
public class TodoService {
    public static List<Todo> todos = new ArrayList<Todo>();
    public static List<User> users = new ArrayList<User>();
    public static int iddel;
    public static String fullNameKey;
    public static String sortColumn;
    static Logger logger = LoggerFactory.getLogger(TodoService.class);
    Authentication authentication;
    UserDetails userDetails;




    public void refresh(){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        userDetails = (UserDetails) authentication.getPrincipal();
        iddbl = new ArrayList<Integer>();
        fullNameDbl = new ArrayList<String>();
        iinDbl = new ArrayList<Integer>();
        passportDbl = new ArrayList<String>();
        dateDbl = new ArrayList<String>();
        discDbl = new ArrayList<String>();
        addInfoDbl = new ArrayList<String>();
        addressDbl = new ArrayList<String>();
        phoneNumberDbl = new ArrayList<Integer>();
        propDbl = new ArrayList<String>();


        database.main(null);
        logger.info("size in service:"+size+"/"+countdb);
        if(countdb != 0){
            for (int i = 0; i < size; i++) {

                todos.add(new Todo(iddbl.get(i),  userDetails.getUsername(), fullNameDbl.get(i), iinDbl.get(i), passportDbl.get(i), dateDbl.get(i), discDbl.get(i), addInfoDbl.get(i),  addressDbl.get(i), phoneNumberDbl.get(i), propDbl.get(i)));
                logger.info("todosIns:" + iddbl);
            }

        }
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equalsIgnoreCase(user)) {
                filteredTodos.add(todo);
           }
        }
        return filteredTodos;
    }

    
    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(Todo todo){
            todos.remove(todo);
            todos.add(todo);


    }

    public void addTodo(String name, String fullName, Integer iin, String passport, String date, String disc, String add_inf,
                        String address, Integer phoneNumber, String prop) {
        todos.add(new Todo(indf, name, fullName, iin, passport, date, disc, add_inf, address, phoneNumber, prop));
    }

    public void addUser(String login, String password, String passwordChecker, String role, String enabled) {
        users.add(new User(login, password, passwordChecker, role, enabled));
    }


    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
                iddel = id;
                dbdelete.main(null);
            }
        }
    }

    public void searchTodo(String findTitle) {
                fullNameKey = findTitle;
                dbsearch.main(null);
    }

    public void sortTodo(String selCol) {
        sortColumn = selCol;
        dbsorting.main(null);
    }
}