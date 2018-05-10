# Java容器
## Java容器类的继承结构
Java容器类库定义了两个不同概念的容器，Collection和Map。  
**Collection**：一个独立元素的序列，这些元素都服从一条或多条规则。List必须按照插入的顺序保存元素；Set不能有重复元素；Queue按照排队规则来确定对象产生的顺序。  

<image src="images/java-container-brief-introduction-01.jpg">  

**Map**:一组成对的“键值对”对象，允许我们使用键来查找值。  

<image src="images/java-container-brief-introduction-02.jpg">  

Mapn内部接口Entry<K,V>对应着Map的键值对。  

##迭代器
