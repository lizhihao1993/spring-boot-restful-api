package com.ideabook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
    1.restful风格框架: GET用来获取资源，POST用来新建资源（也可以用于更新资源），PUT用来更新资源，DELETE用来删除资源。
    具体设计以及常见误区 : http://www.ruanyifeng.com/blog/2011/09/restful.html
    2.restful架构：
　　（1）每一个URI代表一种资源；
　　（2）客户端和服务器之间，传递这种资源的某种表现层；
　　（3）客户端通过四个HTTP动词，对服务器端资源进行操作，实现"表现层状态转化"。

	3.HTTP 知识补充
	GET            请求获取Request-URI所标识的资源
	POST          在Request-URI所标识的资源后附加新的数据
	HEAD         请求获取由Request-URI所标识的资源的响应消息报头
	PUT            请求服务器存储一个资源，并用Request-URI作为其标识
	DELETE       请求服务器删除Request-URI所标识的资源
	TRACE        请求服务器回送收到的请求信息，主要用于测试或诊断
	CONNECT  保留将来使用
    OPTIONS   请求查询服务器的性能，或者查询与资源相关的选项和需求

    具体解释：http://www.bysocket.com/?spm=5176.100239.blogcont69790.21.zVC1z1&p=282

    4.奇怪：改为war打包后，启动正常。。。。
    5.swagger2接口说明： http://localhost:8080/swagger-ui.html
    6.jpa update方法，返回参数为Integer/int
     SpringBoot-jpa demo https://github.com/cloudfavorites/favorites-web/blob/master/src/main/java/com/favorites/repository/UserRepository.java
    7.接口返回参数有待改善，返回的值不一定全是success,应该随结果变化。
 */

@SpringBootApplication
@EnableSwagger2
public class SpringBootRestfulApiApplication extends SpringBootServletInitializer {

 /*   @Override   //不注释 无法打包缺少东西
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }*/

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootRestfulApiApplication.class, args);
	}

}
