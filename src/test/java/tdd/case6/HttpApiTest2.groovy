package tdd.case6

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.HttpResponseException
import org.apache.http.HttpResponse
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.URLENC

@Stepwise
class HttpApiTest2 extends Specification {

  @Shared
  def http = new HTTPBuilder("http://mock-api.com/k7gPXAgl.mock/spock/");

  def page_load() {
    when:
    def response = http.get([path: 'hello']);
    //{"hello":"world"}
    then:
    response.hello == 'world';
  }

  def login_success() {
    when:
    def response = http.post([path              : 'login',
                              requestContentType: URLENC,
                              body              : ["username": "root",
                                                   "password": "root"
                              ]
    ]);
    //{"hello":"world"}
    then:
    response.success == true;
    response.username == 'root';
  }

  @Shared
  def response;

  def search() {
    when:
    def response = http.get([path: 'product/_search'
    ]);
    //{"hello":"world"}
    then:
    response.page == 1
    response.content.size() == 2;
    response.content.name == ["张三", "李四"]
    response.total == 4;
    cleanup:
    this.response = response;
  }

  def next() {
    when:
    def response = http.get([path : 'product/_search',
                             query: [page: this.response.page + 1]
    ]);
    //{"hello":"world"}
    then:
    response.page == 2
    response.content.size() == 2;
    response.total == 4;
  }

  def logout() {
    when:
    def response = http.post([path: 'logout'
    ]);
    //{"hello":"world"}
    then:
    response.success == true
  }

  def return_401_if_not_login() {
    when:
    def response = http.get([path : 'product/_search',
                             query: [page: 3]
    ]);
    //{"hello":"world"}
    then:
    HttpResponseException e = thrown()
    e.getStatusCode() == 401;
  }

}
