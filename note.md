依赖注入 : 就是利用set方法来进行注入的.
set注入后程序不在具有主动性，而变为被动接受


Ioc:对象由Spring 来创建 , 管理 , 装配 !
## 注解说明
- @Autowired默认byType，@Resource默认byName。

- spring注解 @Autowired 默认byType装配，bean的class属性是同源关系的
            @Autowired、 @Qualifier(value = "xx") 组合按byName装配，bean的id名称一样，且数据类型是一致的

- java元注解 @Resource 默认byName装
            @Resource(name="xx")      name：指定需注入的bean的名称(id)
                type： 指定需注入的bean的类型(class)


- @Component组件 放在类上 说明被spring管理了
- @Controller：web层
- @Service：service层
- @Repository：dao层

- logImpl SLF4J | LOG4J（3.5.9 起废弃） | LOG4J2 | JDK_LOGGING | COMMONS_LOGGING | STDOUT_LOGGING | NO_LOGGING