# UML-class
类  
接口  
类之间的关系  

类
<image src="images/class.jpg">  

继承（泛化）Generalization  
一个类（称为子类、子接口）继承另外的一个类（称为父类、父接口）的功能，并可以增加自己的新功能的能力，继承是类与类或接口与接口之间最常见的关系；extends。  
带三角箭头的实现，箭头指向父类。  
<image src="images/extends.jpg">

实现 Realization  
一个class类实现Interface接口（可以是多个）的功能；实现时类与接口之间最常见的关系；implements。  
带三角箭头的虚线，箭头指向接口。  
<image src="images/implements.jpg">  

依赖  
一个类A使用到了另一个类B，而这种使用关系时具有偶然性、临时性的；表现在代码层面，类B作为参数被类A在某个Method方法中使用。  
带箭头的虚线，指向被使用者。  
<image src="images/Dependence.jpg">  

关联 Association  
两个类或类与接口之间语义级别的一种强依赖关系，这种关系比依赖更强，一般是长期性的，而且双方的关系一般是平等的，关联可以是单向的、双向的；表现在代码层面，被关联类B以属性的形式出现在关联类A中，或关联类A引用了一个类型为被关联类B的全局变量。  
带普通箭头的实心线，指向被拥有者；双向的关联有两个箭头或没有箭头，单向的关联有一个箭头。  
<image src="images/Association.jpg">  

聚合 Aggregation  
聚合是关联关系的一种特例，它体现的是整体与部分、拥有的关系，即has-a的关系，此时整体与部分是可以分离的。  
带空心菱形的实心线，菱形指向整体。  
<image src="images/Aggregation.jpg">  

组合  
组合也是关联关系的一种特例，它体现的是一种contains-a的关系，这种关系比聚合更强，也称为强聚合；整体与部分是不可分的。  
带实心菱形的实线，菱形指向整体。  
<image src="images/Composition.jpg">  

泛化 = 实现 > 组合 > 聚合 > 关联 > 依赖  

<image src="images/all.png">  

[参考](http://www.jianshu.com/p/4cd95d4ddb59)