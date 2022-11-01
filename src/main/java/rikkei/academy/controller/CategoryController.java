package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rikkei.academy.dto.response.ResponseMessage;
import rikkei.academy.model.Category;
import rikkei.academy.model.User;
import rikkei.academy.security.userprincipal.UserDetailsServiceIMPL;
import rikkei.academy.service.category.ICategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private UserDetailsServiceIMPL userDetailsServiceIMPL;
    @PostMapping
    public ResponseEntity<?>createCategory(@RequestBody Category category){
        User user = userDetailsServiceIMPL.getCurrentUser();
        if (user.getUsername().equals("Anonymous")){
            return new ResponseEntity<>(new ResponseMessage("ko co dang nhap"), HttpStatus.OK);
        }
        categoryService.save(category);
        return new ResponseEntity<>(new ResponseMessage("create category success !!!"),HttpStatus.OK);
    }
}
