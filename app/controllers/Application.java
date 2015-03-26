package controllers;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.http.HttpRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import play.*;
import play.libs.Json;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;

import play.api.libs.json.JsObject;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your newd application is ready."));
    }


	public static Result getJSON() {
		try
		{
			
			String consumerKeyStr = "U8YfTDGY4oCFRzGrsoQnZvOEq";
			String consumerSecretStr = "MiTGHxQ9jhc9TsC1xhYxQiK1CtBjQ9aaRNENkS2vFGqJZTYOBa";
			String accessTokenStr = "3097959710-eC14COSvWCKLBB6DNCzj77W8ud6blRqHrcBkCIF";
			String accessTokenSecretStr = "Tpic7Ua2OJqXBlTiNelTqkA7L6ATGhBrg5vX3Rw0dmJkW";

			OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
			oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

			//取得最近30篇蘋果日報的文章
			HttpGet httpPost = new HttpGet("https://api.twitter.com/1.1/statuses/home_timeline.json?count=16&screen_name=TW_nextmedia");
			
			oAuthConsumer.sign(httpPost);
			
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse httpResponse = httpClient.execute(httpPost);

			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println(statusCode + ':'	+ httpResponse.getStatusLine().getReasonPhrase());
			BufferedReader rd = new BufferedReader( new InputStreamReader(httpResponse.getEntity().getContent()));
			
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			return ok(result.toString());//retrun JSON result

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return ok("ok");
	}


}
