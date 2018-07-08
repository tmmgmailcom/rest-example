package pl.sda.restexample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post addNewPost(@RequestBody Post postToAdd){
        return postRepository.save(postToAdd);
    }
}
