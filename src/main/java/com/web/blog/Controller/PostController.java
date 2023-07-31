package com.web.blog.Controller;
import com.web.blog.exception.ResourceNotFoundException;
import com.web.blog.DTO.PostDTO;
import com.web.blog.DTO.PostSaveDTO;
import com.web.blog.Repo.PostRepo;
import com.web.blog.Repo.UserRepo;
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
    private UserRepo userRepo;
    private User user;

    @Autowired
    private PostRepo postRepo;
//    @PostMapping(path="/create")
//    public Post createPost(@RequestBody PostSaveDTO postSaveDTO, @RequestParam("username") String username) {
//        User user = userService.getUserByUsername(username);
//        postSaveDTO.setUsername(user);
//        return postService.addPost(postSaveDTO);
//    }
//    @PostMapping(path = "/save")
//    public String savePost(@RequestBody PostSaveDTO postSaveDTO){
//        String Id= postService.addPost(postSaveDTO);
//        return  Id;
//    }
    @PostMapping(path="/createPostByUserId/{user_id}/createPost")
    public ResponseEntity<Post> createPostByUserId(@PathVariable(value = "user_id") Long userId,
                                                 @RequestBody Post postRequest) {
        Post post = userRepo.findById(userId).map(user -> {
            postRequest.setUser(user);
            return postRepo.save(postRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + userId));

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
//    @GetMapping(path="/getPostsByUserId/{user_id}")
//    public ResponseEntity<Post> getPostsByUserId(@PathVariable(value = "user_id") Long userId) {
//        Post post = postRepo.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("Not found Comment with id = " + userId));
//
//        return new ResponseEntity<>(comment, HttpStatus.OK);
//    }
@GetMapping("/getAllPostsByUserId/{user_id}/getPosts")
public ResponseEntity<List<Post>> getAllPostsByUserId(@PathVariable(value = "user_id") Long userId) {
    if (!userRepo.existsById(userId)) {
        throw new ResourceNotFoundException("Not found User with id = " + userId);
    }

    List<Post> comments = postRepo.findByUserId(userId);
    return new ResponseEntity<>(comments, HttpStatus.OK);
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
    @DeleteMapping(path = "/deletePost/{post_id}")
    public String deletePost(@PathVariable(value = "post_id") long id) {
        boolean postDelete = postService.deletepost(id);

        return "deleted";
    }
    @GetMapping(path="/postsByUserId/{id}")
    public ResponseEntity<List<Post>> getAllCommentsByUserId(@PathVariable(value = "id") Long userId) {
        if (!userRepo.existsById(userId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + userId);
        }

        List<Post> posts = postRepo.findByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PutMapping(path="/updatePost/{post_id}")
    public ResponseEntity<Post> updateComment(@PathVariable("post_id") long post_id, @RequestBody Post postRequest) {
        Post post = postRepo.findById(post_id)
                .orElseThrow(() -> new ResourceNotFoundException("Post Id " + post_id + "not found"));

        post.setContent(postRequest.getContent());
        post.setTitle(postRequest.getTitle());

        return new ResponseEntity<>(postRepo.save(post), HttpStatus.OK);
    }
    @GetMapping("/getPost/{post_id}")
    public ResponseEntity<Post> getAdminById(@PathVariable("post_id") long post_id) {
        Optional<Post> postData = postRepo.findById(post_id);

        if (postData.isPresent()) {
            return new ResponseEntity<>(postData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping(path = "/deletePost/{id}")
//    public String deletepost(@PathVariable(value = "id") long id)
//    {
//        boolean deletepost = postService.deletepost(id);
//        return "deleted";
//    }



}
