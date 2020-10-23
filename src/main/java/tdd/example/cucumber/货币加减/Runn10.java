package tdd.example.cucumber.货币加减;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/**
 * 运行cucumber案例
 * 
 * 文档：https://cucumber.io/docs/cucumber/api/#list-configuration-options
 *
 *
 * @author lxb
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        //可以是feature文件、包含feature的文件夹
        features = "src/main/resources/currency.feature", 
        //严格模式，ignore会变成failure
        strict=true,
        plugin = "pretty",
        //step代码的包
        glue = {
        "tdd.example.cucumber" })
public class Runn10 {

}
