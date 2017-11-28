# Spring Security #
## 基础知识  ##

Spring Security为我们提供了一个多个过滤器来实现所有安全的功能，我们只需要注册一个特殊的DelegatingFilterProxy过滤器到WebApplicationInitializer即可。
在实际使用中，我们只需要让自己的Initializer类继承AbstractSecurityWebApplicationInitializer抽象类即可。

### 配置 ###
Spring Security只需在一个配置类上注解@EnableWebSecurity，并且让这个类继承WebSecurityConfigurerAdapter即可

### 用户认证 ###
需要我们有一套用户数据的来源，而授权则是对于某个用户有相应角色的权限。在Spring Security里我们通过重写  configure(AuthenticationManagerBuilder auth) 方法来实现定制
 - 内存中的用户 使用 auth的inMemoryAuthentication方法即可添加在内存中的用户，并可给用户指定角色权限。  
 - JDBC中的用户   直接使用auth.jdbcAuthentication().dataSource(datasource)  
 - 通用的用户，需要自定义实现UserDetailsService 接口

### 请求授权 ###
通过重写configure(HttpSecurity http) 方法来实现请求拦截

## Spring Boot 支持 ##

当我们需要自己扩展配置的时候，只需配置类继承WebSecurityConfigurerAdapter即可