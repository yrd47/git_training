#IO

**java.io**

<image src="images/io.jpeg">

##Java IO概述
Java的IO主要关注的是从原始数据源的读取以及输出原始数据到目标媒介。以下是典型的数据源和目标媒介：  
文件；管道；网络连接；内存缓存；Java标准输入、输出、错误输出。  
 
**流**  
连续的数据流，可以从流中读取数据，也可以往流中写数据。流与数据源或数据流向的媒介相关联。流既可以是字节流（以字节为单位进行读写），也可以是字符流（以字符为单位进行读写）。  

InputStream/Reader从数据源读取数据  
OutputStream/Writer将数据写入到目标媒介中  

Java IO中包含了许多InputStream、Reader、OutputStream、Writer的子类，让每个类负责不同的功能：文件访问  网络访问  内存缓存访问  线程内部通信（管道）  缓冲  过滤  解析  读写文本  读写基本数据类型  读写对象。  

<image src="images/IO1.png">  

##Java IO:文件
File类

##Java IO:字节流
输入流：InputStream  
输出流：OutputStream  
读写文件：FileInputStream、FileOutputStream    
读写对象：ObjectInputStream、ObjectOutputStream, 该流允许读取或写入用户自定义的类，但是要实现这种功能，被读取和写入的类必须实现Serializable接口    
DataInputStream、DataOutputStream, readUTF()、readInt()  
SequenceInputStream 合并流，将多个源合并为一个源  
PrintStream System.out.print()  

##Java IO:字符流





##Java IO:管道
Java IO中的管道为运行在同一个JVM中的两个线程提供了通信的能力。通信的双方应该是在同一个进程中的不同线程。  
PipedOutputStream  
PipedInputStream   



  
[Java IO 详解](http://davidisok.iteye.com/blog/2106489)  
[Java IO教程-并发编程网](http://ifeve.com/java-io/)  
[字符与字节](https://www.zhihu.com/question/39262026)