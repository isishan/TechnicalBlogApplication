package upgrad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import upgrad.model.Post;
import upgrad.service.PostService;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping("posts")
    public String getPost(Model model) throws SQLException, ClassNotFoundException {

        ArrayList<Post> post = postService.getOnePost();

        model.addAttribute("posts", post);

        return "posts";
    }

    @RequestMapping("posts/create")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(value = "posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost){

        postService.createPost(newPost);

        return "redirect:/posts";
    }

}
