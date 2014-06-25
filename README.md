eMall
=====

> 大型超市运营系统，这是为IBM Mainframe而开发的运营系统，虽然最后未能完成，但是框架均已搭好。

##系统架构

基于`GWT+EJB+JPA`，标准的JAVA EE web应用。

##封装

用Java反射和递归调用，为JPA 实体类封装了统一的`toString()`，便于打印实体对象。用EJB的stateless session bean，结合JPA的`EntityManager`与Java泛型，封装了统一的`Generic EAO`类。通过继承此`Generic EAO`类，一个实体可以迅速获到自己的EAO类。用Servlet封装了简易的测试框架，在不启动笨重的GWT插件的前提下，快速测试业务方法。基于GWT的MVP开发模式，提取出单独`core`层，这样可以只使用一个`MVP`架构，分模块开发项目。
