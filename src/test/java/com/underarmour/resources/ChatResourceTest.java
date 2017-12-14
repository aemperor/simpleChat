package com.underarmour.resources;

import com.underarmour.db.ChatDAO;
import com.underarmour.model.Chat;
import com.underarmour.model.Text;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.anyLong;



/**
 * Unit test for the ChatResource functionality.
 */
public class ChatResourceTest {

	@Mock
	ChatDAO _chatDAO;

	ChatResource _chatResource;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		_chatResource = new ChatResource(_chatDAO);
		_chatResource.chatDAO = _chatDAO;
	}

	/**
	 * Tests null pointer exception thrown when no object is passed in for create.
	 */
	@Test(expected = NullPointerException.class)
	public void testCreateWithException() {
		_chatResource.create(null);
	}

	/**
	 * Tests response functionality of ChatResource#create.
	 */
	@Test
	public void testCreate() {
		Response response = _chatResource.create(mock(Chat.class));
		Assert.assertNotNull(response.getEntity());
	}

	/**
	 * Tests response functionality of ChatResource#getById.
	 */
	@Test
	public void testGetById() {
		List<Chat> chats = new ArrayList<>();
		chats.add(mock(Chat.class));
		chats.add(mock(Chat.class));

		when(_chatResource.chatDAO.findAllChatsForId(eq(1l))).thenReturn(chats);

		Response response = _chatResource.getById(1l);
		Assert.assertNotNull(response.getEntity());
		Assert.assertEquals(chats, response.getEntity());
	}

	/**
	 * Tests response functionality of ChatResource#getByUsername.
	 */
	@Test
	public void testGetByUsername() {
		List<Text> texts = new ArrayList<>();
		texts.add(mock(Text.class));
		texts.add(mock(Text.class));

		when(_chatResource.chatDAO.findAllUnexpiredChatsForUserName(eq("user"), anyLong())).thenReturn(texts);

		Response response = _chatResource.getByUsername("user");
		Assert.assertNotNull(response.getEntity());
		Assert.assertEquals(texts, response.getEntity());
	}
}
