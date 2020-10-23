package tdd.example

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import groovyx.net.http.HTTPBuilder
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.junit.jupiter.api.Test

import static groovyx.net.http.ContentType.JSON
import static org.assertj.core.api.Assertions.assertThat

class HttpClientDemo {
  @Test
  public void apache_http() throws Exception {
    CloseableHttpClient client = HttpClientBuilder.create().build();

    HttpUriRequest request = RequestBuilder.get("http://mock-api.com/k7gPXAgl.mock/spock/hello")
        .build();

    CloseableHttpResponse response = client.execute(request);

    assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);

    def tree = new ObjectMapper().readTree(response.getEntity().getContent());
    assert tree.get("hello").asText() == "world";
  }

  @Test
  void groovy_http_get() {
    def text = new URL("http://www.baidu.com").text;
    println text;
  }

  @Test
  void http_builder() {

    def base = "http://mock-api.com/k7gPXAgl.mock/spock/";
    def http = new HTTPBuilder(base);
    def response = http.get([path: 'hello']);
    //{"hello":"world"}
    assert response.hello == 'world';

  }
}
