package singleton;


/*
 * 1.私有的构造函数，表名这个类是不可能形成实例了。主要防止这个类有多个实例
 * 2.既然这个类是不可能形成实例，那么我们需要一个静态的方式让其形成实例：getINstance()。这个方法是在new自己，因为其可以访问私有的构造函数，所以他可以保证实例被创建出来
 * 3.在getInstance()中，先做判断是否已形成实例，如果已形成则直接返回，否则创建实例
 * 4.所形成的实例保存在自己类中的私有成员中
 * 5.取实例时，只需要使用Singleton.getIntance()就可以
 */
public class Singleton {
	private static Singleton singleton = null;
	private Singleton() { }
	public static Singleton getInstance(){
		if (singleton == null){
			singleton = new Singleton();
		}
		return singleton;
	}

}


