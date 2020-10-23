package tdd.groovy

import org.junit.jupiter.api.Test
import tdd.domain.Account

class HelloWorld {

  static void main(String[] args) {
    println "Hello World!"
  }

  @Test
  public void 例子() {

    def bean = new Account(username: "张三", password: "***");
    //等价于bean.getUsername();
    println bean.username;
    //等价于 bean.setPassword("***")
    println bean.password == "***"
    //等价于 bean.username.equals("张三")
    assert bean.username == "张三"


    //双引号字符串可以嵌入变量
    String name = '👶'
    System.out.println("$name");

    //list声明
    List<String> team = ['张三', '李四'];
    String[] team2 = ['👶', '👴']
    println(team)
    //list访问
    println team[0]
    println team.get(0)

    //new HashMap<>;
    Map map = [:]
    Map map2 = [child: "小朋友", parent: '爷爷']
    //Map访问
    println map2.get("child");
    println map2.child
    println map2['child'];

    //数组访问
    List list = ["a", "b", "c"]
    assert list[0..1] == ["a", "b"];
    List list2 = [new Account("张三"), new Account("李四")]
    assert list2.username == ["张三", "李四"]
    assert list2.collect({ it -> it.username }) == ["张三", "李四"]
    list2.find({ it -> it.username == "张三" })
    println map?.username
    //括号可以省掉

    def fn = { it ->
      return it + 1;
    }
    //(it) -> { return it+1;}

    println fn.call(1)
  }

}
