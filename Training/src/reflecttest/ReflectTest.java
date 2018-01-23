package reflecttest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yrd on 2017/7/28.
 *
 */

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {
        //通过类加载器获取Car对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflecttest.Car");

        //获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CACA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }

}
