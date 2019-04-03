package helpers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class WallHelper {
	private HttpClient client;
	private String accessToken;

	public WallHelper(String accessToken) {
		client = HttpClientBuilder.create().build();
		this.accessToken = accessToken;
	}

	public String getMessages(String userId)
			throws ClientProtocolException, IOException, URISyntaxException {
		URIBuilder getBuilder = new URIBuilder("https://api.vk.com/method/wall.get?");
		getBuilder.setParameter("access_token", accessToken)
				.setParameter("owner_id", userId)
				.setParameter("count", "2")
				.setParameter("v", "5.92");
		HttpGet request = new HttpGet(getBuilder.build());
		HttpResponse response = client.execute(request);
		String stringResponse = EntityUtils.toString(response.getEntity());
		return stringResponse;
	}
	
	public String postMessage(String userId, String messageText, String attachmentId)
			throws ClientProtocolException, IOException, URISyntaxException {
		URIBuilder postBuilder = new URIBuilder("https://api.vk.com/method/wall.post?");
		postBuilder.setParameter("access_token", accessToken)
				.setParameter("owner_id", userId)
				.setParameter("message", messageText)
				.setParameter("attachments", attachmentId)
				.setParameter("v", "5.92");
		HttpGet request = new HttpGet(postBuilder.build());
		HttpResponse response = client.execute(request);
		String messageId = EntityUtils.toString(response.getEntity()).replaceAll("[^0-9]", "");
		return messageId;
	}
	
	public void editMessage(String userId, String postId, String newText) throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder editBuilder = new URIBuilder("https://api.vk.com/method/wall.edit?");
		editBuilder
				.setParameter("access_token", accessToken)
				.setParameter("owner_id", userId)
				.setParameter("post_id", postId)
				.setParameter("message", newText)
				.setParameter("v", "5.92");
		HttpGet request = new HttpGet(editBuilder.build());
		client.execute(request);
	}
	
	public void deleteMessage(String userId, String postId) throws URISyntaxException, ClientProtocolException, IOException {
		URIBuilder deleteBuilder = new URIBuilder("https://api.vk.com/method/wall.delete?");
		deleteBuilder.setParameter("access_token", accessToken)
				.setParameter("owner_id", userId)
				.setParameter("post_id", postId)
				.setParameter("v", "5.92");
		HttpGet request = new HttpGet(deleteBuilder.build());
		client.execute(request);
	}
}
