package com.kodbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.Post;
import com.kodbook.repositories.PostRepository;

@Service
public class PostServiceImplementation implements PostService{
	
	@Autowired
	PostRepository postRepo;

	@Override
	public void createPost(Post post) {
		postRepo.save(post);
		
	}

	@Override
	public List<Post> fetchAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

}
