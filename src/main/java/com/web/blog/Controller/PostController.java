package com.web.blog.Controller;

import com.web.blog.DTO.PostDTO;
import com.web.blog.DTO.PostSaveDTO;
import com.web.blog.Repo.PostRepo;
import com.web.blog.Serice.PostService;
import com.web.blog.Serice.UserService;
import com.web.blog.model.Post;
import com.web.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/blog/post")
public class PostController {
    @Autowired
    private PostService postService;


    @Autowired
    private PostRepo postRepo;
//    @PostMapping(path="/create")
//    public Post createPost(@RequestBody PostSaveDTO postSaveDTO, @RequestParam("username") String username) {
//        User user = userService.getUserByUsername(username);
//        postSaveDTO.setUsername(user);
//        return postService.addPost(postSaveDTO);
//    }
    @PostMapping(path = "/save")
    public String savePost(@RequestBody PostSaveDTO postSaveDTO){
        String Id= postService.addPost(postSaveDTO);
        return  Id;
    }

//    public List<PostDTO> getAllPost()
//    {
//        List<PostDTO> allPost = postService.getAllPost();
//        return allPost;

    @GetMapping(path = "/getAllPost")
    public ResponseEntity<List<PostDTO>> showAllPosts() {
        return new ResponseEntity<List<PostDTO>>(postService.showAllPosts(), HttpStatus.OK);
    }
//    @GetMapping("/getById/{id}")
//    public ResponseEntity<PostDTO> getSinglePost(@PathVariable @RequestBody Long id) {
//        return new ResponseEntity<PostDTO>(postService.readSinglePost(id), HttpStatus.OK);
//    }
    @GetMapping(path="/getById/{id}")
    public ResponseEntity<Post> getCrudById(@PathVariable("id") long id) {
    Optional<Post> crudData = postRepo.findById(id);

    if (crudData.isPresent()) {
        return new ResponseEntity<>(crudData.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    @DeleteMapping(path = "/deletePost/{id}")
    public String deletePost(@PathVariable(value = "id") long id) {
        boolean deletepost = postService.deletepost(id);

        return "deleted";
    }

//    @DeleteMapping(path = "/deletePost/{id}")
//    public String deletepost(@PathVariable(value = "id") long id)
//    {
//        boolean deletepost = postService.deletepost(id);
//        return "deleted";
//    }



}
