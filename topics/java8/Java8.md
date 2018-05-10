#<center> Java8特性
## 1.简介
语言  
编译器  
类库  
开发工具  
运行时（JVM）
## 2.Java语言的新特性
### 2.1 Lambda表达式和函数式接口
Lambda表达式（闭包）  
允许我们将函数当成参数传给某个方法，或者把代码本身当做数据处理（原来只能使用匿名内部类替代Lambda表达式）  
```Arrays.asList("a","b","c").forEach(e -> System.out.println(e);```  
Lambda表达式有返回值若语句只有一行，可以不使用return语句  
函数接口：只有一个函数的接口，这样的接口可以隐式转换为Lambda表达式。java.lang.Runnable和java.util.concurrent.Callable是函数式接口的最佳例子。  
@FunctionalInterface	默认方法和静态方法不会破坏函数式接口的定义  
### 2.2 接口的默认方法和静态方法
默认方法会被接口的实现类继承或覆写  
### 2.3 方法引用
方法引用使得开发者可以直接引用现存的方法、Java类的构造方法或实例对象
### 2.4 重复注解
@Repeatable 允许在同一个地方多次使用同一个注解
### 2.5 更好的类型推断
### 2.6 拓宽注解的应用场景
现在，注解几乎可以使用在任何元素上：局部变量、接口类型、超类和接口实现类，甚至可以用在函数的异常定义上  
## 3. Java编译器的新特性
## 4. Java官方库的新特性
Java8增加了很多新的工具类（date/time类），并扩展了现存的工具类，以支持现代的并发编程、函数式编程等
### 4.1 Optional
解决NullPointerException
### 4.2 Streams
新增的Stream API（java.util.stream）将生成环境的函数式编程引入了Java库中。这是目前为止最大的一次对Java库的完善，以便开发者能够写出更加有效、更加简洁和紧凑的代码  
### 4.3 Date/Time API
新的java.time包包含了所有关于日期、时间、时区、Instant（跟日期类似但是精确到纳秒）、duration（持续时间）和时钟操作的类  
### 4.4 Nashorn JavaScript引擎
### 4.5 Base64
### 4.6 并行数组
parallelSort()，可以显著加快多核机器上的数组排序  
### 4.7 并发性
## 5. 新的Java工具
### 5.1 Nashorn引擎:jjs
### 5.2 类依赖分析器：jdeps
jdeps是一个相当棒的命令行工具，它可以展示包层级和类层级的Java类依赖关系，它以.class文件、目录或者Jar文件为输入，然后会把依赖关系输出到控制台  
## 6. JVM的新特性
使用Metaspace（JEP 122）代替持久代（PermGen space）。在JVM参数方面，使用-XX:MetaSpaceSize和-XX:MaxMetaspaceSize代替原来的-XX:PermSize和-XX:MaxPermSize  
## 7.参照
http://www.jianshu.com/p/5b800057f2d8
