package core;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VkTests {
	private static final String MESSAGE_TEXT = "test";
	private static final String NEW_TEXT = "test updated";
	private static final String OWNER_ID = "19254823";
	private static final String ATTACHMENT_ID = "photo19254823_456244495";
	// constant(timeless) token is generated with 'scope=offline' parameter in
	// https://oauth.vk.com/authorize?client_id=6901011&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=wall,offline&response_type=token&v=5.92&state=123456
	private static final String CONSTANT_ACCESS_TOKEN = "f60b90864044ea027ca09cbd9c6a8e4a6e809f2ce5b47a80f261045f5ff0be0859c148c1ab2e21718e7e8";
	private WallHelper wallHelper;

	@Before
	public void setUp() {
		wallHelper = new WallHelper(CONSTANT_ACCESS_TOKEN);
	}


	@Test
	public void postMessageTest() throws URISyntaxException, ClientProtocolException, IOException {	
		String postId = wallHelper.postMessage(OWNER_ID, MESSAGE_TEXT, ATTACHMENT_ID);
		String stringResponse = wallHelper.getMessages(OWNER_ID);	
		Assert.assertTrue(stringResponse.contains("\"text\":\"" + MESSAGE_TEXT + "\""));
		
		// post conditions
		wallHelper.deleteMessage(OWNER_ID, postId);
	}

	@Test
	public void editMessageTest() throws URISyntaxException, ClientProtocolException, IOException {
		String postId = wallHelper.postMessage(OWNER_ID, MESSAGE_TEXT, ATTACHMENT_ID);
		wallHelper.editMessage(OWNER_ID, postId, NEW_TEXT);
		String stringResponse = wallHelper.getMessages(OWNER_ID);
		Assert.assertTrue(stringResponse.contains("\"text\":\"" + NEW_TEXT + "\""));
		
		// post conditions
		wallHelper.deleteMessage(OWNER_ID, postId);
	}

	@Test
	public void deleteMessageTest() throws URISyntaxException, ClientProtocolException, IOException {
		String postId = wallHelper.postMessage(OWNER_ID, MESSAGE_TEXT, ATTACHMENT_ID);
		wallHelper.deleteMessage(OWNER_ID, postId);
		String stringResponse = wallHelper.getMessages(OWNER_ID);
		Assert.assertFalse(stringResponse.contains("\"text\":\"" + MESSAGE_TEXT + "\""));
	}

}
