package com.kodbook.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook.entities.Post;
import com.kodbook.services.PostService;

@Controller
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("/createPost")
	public String createPost(@RequestParam("caption") String caption, @RequestParam("photo") MultipartFile photo,
			Model model) {
		Post post = new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
		postService.createPost(post);
//		List<Post> allPosts = postService.fetchAllPosts();
//		model.addAttribute("allPosts", allPosts);
		return "home";
	}

}
