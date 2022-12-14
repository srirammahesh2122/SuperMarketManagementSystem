package com.SuperMarket.demo.Controller;

import com.SuperMarket.demo.dto.PostDto;
import com.SuperMarket.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200/"},
        allowCredentials = "true",
        allowedHeaders = {"*"},
        exposedHeaders = {"*"},
        maxAge= 60*30,
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT }
)
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<?> createData(@RequestBody PostDto postDto){
        postService.createData(postDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getDataById(@PathVariable String id){
        return new ResponseEntity<>(postService.getDataById(id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PostDto> Delete(@PathVariable String id){
        postService.DeleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateData(@RequestBody PostDto postDto){
        postService.createData(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getData(){
        return new ResponseEntity<>(postService.getAllData(), HttpStatus.OK);
    }
}
