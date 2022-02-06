package com.suleevn.springboot.web.controller;

import com.suleevn.springboot.web.database.dbAddUser;
import com.suleevn.springboot.web.database.dbadd;
import com.suleevn.springboot.web.model.Todo;
import com.suleevn.springboot.web.model.User;
import com.suleevn.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Objects;

@Controller
public class NewUserController {

    public static String loginAdd;
    public static String passwordAdd;
    public static String roleAdd = "ROLE_USER";
    public static String enabledAdd = "true";

    @Autowired
    TodoService service;

    @RequestMapping(value = "/new-user", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        model.addAttribute("user", new User("", "",  "", "", ""));
        return "new-user";
    }

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid User user, BindingResult result) {
        if (result.hasErrors() || !Objects.equals(user.getPassword(), user.getPasswordChecker())) {
            model.addAttribute("error", "Пароли не совпадают");
            return "new-user";
        }
        loginAdd = user.getLogin();
        passwordAdd = user.getPassword();

        dbAddUser.main(null);
        service.addUser(user.getLogin(),user.getPassword(),user.getPasswordChecker(), user.getRole(), user.getEnabled());

        return "redirect:/list-todos";

    }

}
