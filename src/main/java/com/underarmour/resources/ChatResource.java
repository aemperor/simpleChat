package com.underarmour.resources;

import com.underarmour.db.ChatDAO;
import com.underarmour.model.Chat;
import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
* Resource to house chat apis
*/
@Path("/chat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ChatResource {
	private final Logger LOGGER = LoggerFactory.getLogger(ChatResource.class);
	private final ChatDAO chatDAO;

	public ChatResource(ChatDAO chatDAO) {
		this.chatDAO = chatDAO;
		try {
			chatDAO.createTable();
		}
		catch(UnableToExecuteStatementException ex) {
			LOGGER.info("Table with name chat already exists");
		}
	}

	/**
	 * Creates a new chat object.
	 * @param chat The chat to be created.
	 * @return The id of the newly created chat.
	 */
	@POST
	public Response create(Chat chat) {
		long id = generateId();

		chatDAO.insertNamed(id, chat.getUser(), chat.getText(), chat.getTimeout());

		Map entity = new HashMap();
		entity.put("id", id);

		return Response.status(Response.Status.CREATED).entity(entity).build();
	}

	@GET
	@Path("{id}")
	public String get(@PathParam("id") long id) {
		return "001";
	}

//	@GET
//	@Path("{username}")
//	public String get(@PathParam("username") String username) {
//		return "001";
//	}

	/**
	 * Generates random id within the bounds of 0 to 1,000,000.
	 * @return The generated id.
	 */
	private long generateId() {
		int UPPER_BOUND = 1000000;
		Random random = new Random();
		long nextId = random.nextInt(UPPER_BOUND);

		// positive ids only
		while (nextId < 0) {
			nextId = random.nextInt(1000000);
		}

		return nextId;
	}
}