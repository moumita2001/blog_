package com.web.blog.Serice;

import com.web.blog.DTO.PostDTO;
import com.web.blog.DTO.PostSaveDTO;
import com.web.blog.model.Post;

import java.util.List;

public interface PostService {
    String addPost(PostSaveDTO postSaveDTO);
//
//   // List<PostDTO> getAllPost();
//
  List<PostDTO> showAllPosts();

    //boolean deleteCustomer(int id);

    //boolean deletepost(long id);

     boolean deletepost(long id);

   // Post createPost(Post post);

    // readSinglePost(long id);
}
