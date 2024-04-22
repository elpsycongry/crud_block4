package com.example.crud1.controller;

import com.example.crud1.model.User;
import com.example.crud1.service.ClassUserService;
import com.example.crud1.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ClassUserService classUserService;
    @GetMapping("/home")
    public ModelAndView directHome(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize,
            @RequestParam(value = "sortBy", required = false , defaultValue = "id") String sortValue,
            @RequestParam(value= "direction", required = false, defaultValue = "asc") String direction
    ) {
        Page<User> userList;
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortValue);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        if (search == null || search.isEmpty()){
            userList = userService.getUserRepository().findAll(pageable);
        } else {
            userList = userService.getUserRepository().findAllByNameContainingIgnoreCase(search, pageable);

        }
        ModelAndView modelAndView = new ModelAndView("/home");

        modelAndView.addObject("revertSort", direction.equals("asc") ? "desc" : "asc" );
        modelAndView.addObject("sort", direction );
        modelAndView.addObject("searchValue",search == null ? "" : search );
        modelAndView.addObject("users", userList);
        return modelAndView;
    }
    @GetMapping("/delete/")
    public String delete(@RequestParam("id") Long id){
        userService.getUserRepository().deleteById(id);
        return "redirect:/home";
    }
    @GetMapping("/create-user")
    public ModelAndView directToCreate(){
        ModelAndView createForm = new ModelAndView("/create");
        createForm.addObject("user", new User());
        createForm.addObject("classList", classUserService.getClassRepository().findAll() );
        return createForm;
    }
    @PostMapping("/create-user")
    public String createUser(@Valid @ModelAttribute User user){
        userService.getUserRepository().save(user);
        return "redirect:/home";
    }

    @GetMapping("/edit/")
    public ModelAndView directToCreate(@RequestParam("id") Long id){
        ModelAndView editForm = new ModelAndView("/edit");
        System.out.println("ok");
        editForm.addObject("user", userService.getUserRepository().findById(id).get());
        editForm.addObject("classList", classUserService.getClassRepository().findAll());
        return editForm;
    }
}
