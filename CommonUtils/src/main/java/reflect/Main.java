package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {
		//Demo1, 通过Java反射机制得到类的包名和类名
		Demo1();
		System.out.println("===============================================");
		Demo2();
		System.out.println("===============================================");
		Demo3();
		System.out.println("===============================================");
		Demo4();
		System.out.println("===============================================");
		Demo5();
		System.out.println("===============================================");
		Demo6();
		System.out.println("===============================================");
		Demo7();
		System.out.println("===============================================");
		Demo8();
		System.out.println("===============================================");
	}
	
	/**
	 * Demo1: 通过Java反射机制得到类的包名和类名
	 */
	public static void Demo1() {
		Person person = new Person();
		System.out.println("Demo1: 包名" + person.getClass().getPackage().getName() + ", " 
				+ "完整类名: " + person.getClass().getName());
	}

	/**
	 * Demo2: 验证所有的类都是Class类的实例对象 
	 * @throws ClassNotFoundException
	 */
	public static void Demo2() throws ClassNotFoundException {
		//定义两个类型都未知的Class
		Class<?> class1 = null;
		Class<?> class2 = null;
		
		//可能抛出 ClassNotFoundException [多用这个写法] 
		class1 = Class.forName("reflect.Person");
		System.out.println("Demo2(写法1)包名: " + class1.getPackage().getName() + ", " 
				+ "完整类名: " + class1.getName());
		
		class2 = Person.class;  
        System.out.println("Demo2:(写法2) 包名: " + class2.getPackage().getName() + "，"   
                + "完整类名: " + class2.getName());  
	}
	
	/**
	 * Demo3: 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在]
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static void Demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> class1 = null;
		class1 = class1.forName("reflect.Person");
		Person person = (Person) class1.newInstance();
		person.setAge(20);
		person.setName("yrd");
		System.out.println("Demo3: " + person.getName() + " : " + person.getAge());
	}
	
	/**
	 * Demo4: 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void Demo4() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> class1 = null;
		Person person1 = null;
		Person person2 = null;
		
		class1 = Class.forName("reflect.Person");
		//得到一系列构造函数集合 
		Constructor<?>[] constructors = class1.getConstructors();
		
		person1 = (Person) constructors[0].newInstance();
		person1.setAge(20);
		person1.setName("yrd");
		person2 = (Person) constructors[1].newInstance(25, "dd");
		
		System.out.println("Demo4: " + person1.getName() + " : " + person1.getAge()  
        + "  ,   " + person2.getName() + " : " + person2.getAge());  
	}

	/**
	 * Demo5: 通过Java反射机制操作成员变量, set 和 get
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static void Demo5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<?> class1 = null;
		class1 = Class.forName("reflect.Person");
		Object object = class1.newInstance();
		
		Field personNameField = class1.getDeclaredField("name");
		personNameField.setAccessible(true);
		personNameField.set(object, "yrd");
		
		System.out.println("Demo5: 修改属性之后得到属性变量的值：" + personNameField.get(object)); 
	}

	/**
	 * Demo6: 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等 
	 * @throws ClassNotFoundException
	 */
	public static void Demo6() throws ClassNotFoundException {
		Class<?> class1 = null;
		class1 = Class.forName("reflect.SuperMan");
		
		//取得父类名称
		Class<?> superClass = class1.getSuperclass();
		System.out.println("Demo6:  SuperMan类的父类名: " + superClass.getName());
		
		Field[] fields = class1.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {  
            System.out.println("类中的成员: " + fields[i]);  
        }
		
		Method[] methods = class1.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("Demo6,取得SuperMan类的方法：");
			System.out.println("函数名：" + methods[i].getName());  
            System.out.println("函数返回类型：" + methods[i].getReturnType());  
            System.out.println("函数访问修饰符：" + Modifier.toString(methods[i].getModifiers()));  
            System.out.println("函数代码写法： " + methods[i]); 
		}
		
		//取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈  
        Class<?> interfaces[] = class1.getInterfaces();  
        for (int i = 0; i < interfaces.length; i++) {  
            System.out.println("实现的接口类名: " + interfaces[i].getName() );  
        }  
	}

	/**
	 * Demo7: 通过Java反射机制调用类方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static void Demo7() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> class1 = null;
		class1 = Class.forName("reflect.SuperMan");
		
		System.out.println("Demo7: \n调用无参方法fly()：");  
        Method method = class1.getMethod("fly");  
        method.invoke(class1.newInstance());  
          
        System.out.println("调用有参方法walk(int m)：");  
        method = class1.getMethod("walk",int.class);  
        method.invoke(class1.newInstance(),100);  
	}
	
	/**
	 * Demo8: 通过Java反射机制得到类加载器信息 
     *  
     * 在java中有三种类类加载器。[这段资料网上截取] 
 
        1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。 
 
        2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类 
 
        3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。 
	 * @throws ClassNotFoundException
	 */
	public static void Demo8() throws ClassNotFoundException {
		Class<?> class1 = null;
		class1 = Class.forName("reflect.SuperMan");
		String name = class1.getClassLoader().getClass().getName();
		
		System.out.println("Demo8: 类加载器类名: " + name);
	}
}
