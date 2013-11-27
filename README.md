eMall
=====

大型超市运营系统

###系统架构

基于`GWT+EJB+JPA`，标准的JAVA EE web应用。

###封装

#用Java反射和递归调用，为JPA 实体类封装了统一的`toString()`，便于打印实体对象。

#用`EJB`的`stateless session bean`，结合`JPA`的`EntityManager`与Java泛型，封装了统一的`Generic EAO`类。通过继承此`Generic EAO`类，一个实体可以迅速获到自己的EAO类。

#用`Servlet`封装了简易的测试框架，在不启动笨重的`GWT`插件的前提下，快速测试业务方法。

#基于`GWT`的`MVP`开发模式，提取出单独`core`层，这样可以只使用一个`MVP`架构，分模块开发项目。
