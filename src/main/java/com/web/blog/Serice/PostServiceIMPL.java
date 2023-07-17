package com.web.blog.Serice;

import com.web.blog.DTO.PostDTO;
import com.web.blog.DTO.PostSaveDTO;
import com.web.blog.Repo.PostRepo;
import com.web.blog.model.Post;
import com.web.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PostServiceIMPL implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Override
    public String addPost(PostSaveDTO postSaveDTO) {
        Post post = new Post(
                postSaveDTO.getId(),
                postSaveDTO.getTitle(),
                postSaveDTO.getContent(),
                postSaveDTO.getUsername()
        );
        postRepo.save(post);
        return post.getUsername();
    }
////
////    @Override
////    public List<PostDTO> getAllPost() {
////        return null;
//
    public List<PostDTO> showAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    private PostDTO mapFromPostToDto(Post post) {
        PostDTO postDto = new PostDTO();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;
    }

////    @Override
////    public PostDTO readSinglePost(@PathVariable("id") long id) {
////        Post post = postRepo.findById(id).orElse(null);
////        return mapFromPostToDto(post);
////        if (crudData.isPresent()) {
////            return new ResponseEntity<>(crudData.get(), HttpStatus.OK);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//
//    //    public Post getPost(long id) {
////        List<Post> posts = postRepo.findAll();
////        Post post = posts.stream()
////                .filter(t -> id.equals(t.getId()))
////                .findFirst()
////                .orElse(null);
////
////        return post;
////    }
//
////    public Post readSinglePost(long id) {
////        Post post = postRepo.findById(id).orElse(null);
////        return post;
////    }
////    @Override
////    public Optional < PostDTO > findById(Long id) {
////        return postRepo.findById(id);
////}
    @Override
    public boolean deletepost(long id) {
    if(postRepo.existsById(id))
    {
        postRepo.deleteById(id);
    }
    else
    {
        System.out.println("customer id not found");
    }
    return true;
}
////

}