# SpringSecurity OAuth2.0知识整理

最近在研究SpringSecurity的时候发现，这配置是真的复杂概念还很多。所以绝对写一篇文章来强化自己的学习效果，其中若有错误还请大家指正。

# 基本概念

SpringSecurity其实就是一套认证授权框架。主要功能就是`认证`和`授权`。

> 认证：用户认证就是判断一个用户的身份是否合法的过程，用户去访问系统资源时系统要求验证用户的身份信 
>
> 息，身份合法方可继续访问，不合法则拒绝访问。常见的用户身份认证方式有：用户名密码登录，二维码登录，手 
>
> 机短信登录，指纹认证等方式。
>
> 授权：授权是用户认证通过根据用户的权限来控制用户访问资源的过程，拥有资源的访问权限则正常访问，没有 
>
> 权限则拒绝访问。 

说白了就是首先确定是不是你，然后确定你能干啥你不能干啥。

我们先搭建一个小例子。

## 最简SpringSecurity例子

### 依赖

我加多了 只要spring security就行



<img src="https://gitee.com/MFineToo/blog-pic/raw/master/img/20210723224258.png" alt="image-20210723224257886" style="zoom:50%;" />

创建项目之后，配置如下

```java
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .csrf().disable();
    }
}
```

一个个来解释一下：

- WebSecurityConfigurerAdapter：就是通过一个基类方便及创建`spring security  configurer`实例。
- HttpSecurity：类似于XML之前的xml配置，可以为指定的http请求配置基于Web的安全性。默认会用于与所有请求。说白了就是你可以为指定请求配置指定的处理方法，或者指定这个请求不处理。就是一个拦截器而已。
- authorizeRequests：允许使用基本HttpSevletRequest的RequestMatcher实现限制访问的功能
- anyRequest：所有请求
- authenticated:  指定任何经过身份验证的用户都允许url。（ps: 翻译是这样，但是我认为意思是前面指定的url都要经过验证的意思）
- and： 重新给你返回HttpSecurity
- csrf：是指黑客引诱用户打开黑客的网站，在黑客的网站中，利用用户的登录状态发起跨站请求。
- disablle: 关闭

> 上面的配置总体就是在说 所有的请求都要验证并且关闭方csrf的功能。

### 启动项目

![image-20210723234305689](https://gitee.com/MFineToo/blog-pic/raw/master/img/20210723234305.png)

默认用户名user,默认密码：

![image-20210723234342979](https://gitee.com/MFineToo/blog-pic/raw/master/img/20210723234343.png)

输入之后会跳转到一个404页面，不要紧这是正常现象。

![image-20210723234420179](https://gitee.com/MFineToo/blog-pic/raw/master/img/20210723234420.png)

### 相关概念

**主体**：英文单词：principal，使用系统的用户或设备或从其他系统远程登录的用户等等。简单说就是谁使用系统谁就是主体。

**认证**：英文单词：authentication，权限管理系统确认一个主体的身份，允许主体进入系统。简单说就是“主体”证明自己是谁。笼统的认为就是以前所做的登录操作。

**授权**：英文单词：authorization，将操作系统的“权力”“授予”“主体”，这样主体就具备了操作系统中特定功能的能力。

添加一下代码

```java
@RestController
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
```

请求此接口 发现会直接跳转到login界面,输入用户名和密码之后就会跳转到请求的页面。

### PasswordEncoder接口

其实就是你存密码的时候不能存明文，需要被加密。一般采用BCrypt加密。看个简单的测试例子

```java
public class TestPassEncoder {

    @Test
    void testBcrypt() {
        String hashpw = BCrypt.hashpw("123456", BCrypt.gensalt());
        System.out.println(hashpw);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("123456", hashpw));
    }
}
```

结果

![image-20210724000036785](https://gitee.com/MFineToo/blog-pic/raw/master/img/20210724000036.png)

## 用户名密码存Mysql

### 依赖

![image-20210724000649837](https://gitee.com/MFineToo/blog-pic/raw/master/img/20210724000649.png)



