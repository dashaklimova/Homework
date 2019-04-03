package tests;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.WallHelper;

public class VKSteps {
	private static final String MESSAGE_TEXT = "test";
	private static final String NEW_TEXT = "test updated";
	private static final String OWNER_ID = "19254823";
	private static final String ATTACHMENT_ID = "photo19254823_456244495";
	// constant(timeless) token is generated with 'scope=offline' parameter in
	// https://oauth.vk.com/authorize?client_id=6901011&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=wall,offline&response_type=token&v=5.92&state=123456
	private static final String CONSTANT_ACCESS_TOKEN = "f60b90864044ea027ca09cbd9c6a8e4a6e809f2ce5b47a80f261045f5ff0be0859c148c1ab2e21718e7e8";
	private WallHelper wallHelper;
	private String stringResponse;
	private String postId;

	@Before("@API")
	public void before() {
		wallHelper = new WallHelper(CONSTANT_ACCESS_TOKEN);
	}

	@After("@API")
	public void after() throws ClientProtocolException, URISyntaxException, IOException {
		wallHelper.deleteMessage(OWNER_ID, postId);
	}

	@When("^I post message$")
	public void postMessage() throws ClientProtocolException, IOException, URISyntaxException {
		postId = wallHelper.postMessage(OWNER_ID, MESSAGE_TEXT, ATTACHMENT_ID);
	}

	@Then("I see message is posted")
	public void messageIsPosted() throws ClientProtocolException, IOException, URISyntaxException {
		stringResponse = wallHelper.getMessages(OWNER_ID);
		Assert.assertTrue(stringResponse.contains("\"text\":\"" + MESSAGE_TEXT + "\""));
	}

	@And("^I edit message$")
	public void editMessage() throws ClientProtocolException, IOException, URISyntaxException {
		wallHelper.editMessage(OWNER_ID, postId, NEW_TEXT);
	}

	@Then("I see message is edited")
	public void messageIsEdited() throws ClientProtocolException, IOException, URISyntaxException {
		String stringResponse = wallHelper.getMessages(OWNER_ID);
		Assert.assertTrue(stringResponse.contains("\"text\":\"" + NEW_TEXT + "\""));
	}

	@And("^I delete post$")
	public void deleteMessage() throws ClientProtocolException, IOException, URISyntaxException {
		wallHelper.deleteMessage(OWNER_ID, postId);
	}

	@Then("I see post is deleted")
	public void messageIsDeleted() throws ClientProtocolException, IOException, URISyntaxException {
		String stringResponse = wallHelper.getMessages(OWNER_ID);
		Assert.assertFalse(stringResponse.contains("\"text\":\"" + MESSAGE_TEXT + "\""));
	}

}
