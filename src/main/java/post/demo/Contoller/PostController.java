package post.demo.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import post.demo.Model.Post;
import post.demo.Service.PostService;

import javax.validation.Valid;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("posts", this.postService.getAllPosts());
        return "home";
    }
    @GetMapping("/orderByDate")
    public String orderByDate(Model model){
        model.addAttribute("posts", this.postService.getAllPostsByDate());
        return "home";
    }
    @GetMapping("/orderByTitle")
    public String orderByTitle(Model model){
        model.addAttribute("posts", this.postService.getAllPostsByTitle());
        return "home";
    }

    @GetMapping("/details")
    public String showPost(Model model, @RequestParam("id") int id){
        model.addAttribute("post", postService.getPost(id));
        return "details";
    }
    @PostMapping("/update")
    public String updatePost(@Valid @ModelAttribute("post") Post post, BindingResult result){

        if(result.hasErrors()){
            return "details";
        }
        postService.savePost(post);
        return "redirect:/";
    }
    @GetMapping("/newPost")
    public String newPost(Model model){
        model.addAttribute("posts", new Post());
        return "addPost";

    }
    @PostMapping("/newPost")
    public String savePost(@Valid @ModelAttribute("posts") Post post, BindingResult result){
        if(result.hasErrors()){
            return "addPost";
        }
        postService.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/delate")
    public String delate(@RequestParam("id") int id){
        postService.deletePost(id);
        return "redirect:/";
    }

}
