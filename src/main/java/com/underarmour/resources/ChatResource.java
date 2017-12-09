package com.underarmour.resources;

import com.underarmour.db.ChatDAO;
import com.underarmour.model.Chat;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
* Resource to house chat apis
*/
@Path("/chat")
public class ChatResource {
	private final ChatDAO chatDAO;

	public ChatResource(ChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(Chat chat) {
		return "created";
	}

	@GET
	@Path("{id}")
	public String get(@PathParam("id") long id) {
		return "001";
	}

	@GET
	@Path("{username}")
	public String get(@PathParam("username") String username) {
		return "001";
	}
}