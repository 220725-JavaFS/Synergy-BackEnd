package com.revature.services;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.controllers.CommentController;
import com.revature.models.Comment;

@WebMvcTest(CommentController.class)
public class CommentServiceTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CommentService service;
	
	@MockBean
	Comment comment;
	
	@Autowired
	public CommentServiceTest( @RequestBody CommentService commentService) {
		super();
		this.service = commentService;
	}
	
	@Test
	public void CommentShouldGetMessageFromService() throws Exception {
		List<Comment> comments = service.findCommentsByGameId(0);
		when(service.findCommentsByGameId(0)).thenReturn(comments);
		this.mockMvc.perform(get("/comments/"+0)).andDo(print()).andExpect(status().isOk());
//				.andExpect(content().);
	}
	
//	@Test
//	public void CommentShouldAddMessageFromService() throws Exception {
//		
//		List<Comment> comments = service.addOrUpdateComment(comment);
//		when(comments).thenReturn(service.findCommentsByGameId(comment.getGameId()));
//		this.mockMvc.perform(post("/comments/")).andDo(print()).andExpect(status().isCreated())
//				.andReturn(contentType(MediaType.APPLICATION_JSON));
//	}

}
