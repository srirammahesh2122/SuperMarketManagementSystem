package com.SuperMarket.demo.Service;

import com.SuperMarket.demo.dto.PostDto;
import com.SuperMarket.demo.Model.PostModel;
import com.SuperMarket.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PostRepository postRepository;

    public void createData(PostDto postDto){
        PostModel post=new PostModel();
        System.out.println(postDto.getCostPrice());
        System.out.println(postDto.getSalePrice());
        if(postDto.getId()!=null){
            post.setId(postDto.getId());}
        post.setName(postDto.getName());
        post.setQuantity(postDto.getQuantity());
        post.setCostPrice(postDto.getCostPrice());
        post.setSalePrice(postDto.getSalePrice());
        post.setCreatedOn(Instant.now());
        postRepository.save(post);
    }

    public List<PostDto> getAllData(){
        return postRepository.findAll().stream().map(this::mapFromPostToDto).collect(Collectors.toList());
    }
    public PostDto getDataById(String id){
        PostModel post= postRepository.findById(id).get();
        return mapFromPostToDto(post);
    }
    private PostDto mapFromPostToDto(PostModel post){
        PostDto postDto=new PostDto();
        postDto.setId(post.getId());
        postDto.setName(post.getName());
        postDto.setQuantity(post.getQuantity());
        postDto.setCostPrice(post.getCostPrice());
        postDto.setSalePrice(post.getSalePrice());
        return postDto;
    }
    private PostModel mapFromDtoToPost(PostDto postDto){
        PostModel post= new PostModel();
        post.setId(postDto.getId());
        post.setName(postDto.getName());
        post.setQuantity(postDto.getQuantity());
        post.setCostPrice(postDto.getCostPrice());
        post.setSalePrice(postDto.getSalePrice());
        post.setCreatedOn(Instant.now());
        return post;
    }

    public void DeleteById(String id) {
        postRepository.deleteById(id);
    }
}
