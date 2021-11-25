package lesson2;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//这是测试git新增的东西,这是main分支改的东西
public class TeseReleact {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("lesson2.Person");
        //强转成Mytable类型的注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        MyTable annotation = (MyTable) c1.getAnnotation(MyTable.class);
        System.out.println(annotation.value());

        //通过反射活动属性的注解
        Field age = c1.getDeclaredField("age");
        System.out.println("1");
        MyField field = age.getAnnotation(MyField.class);
        System.out.println(field.age());
        System.out.println(field.name());
    }
}

@MyTable("这是测试数据库表Person")
class Person{
    @MyField(name="年龄",age = 10)
    int age;
    @MyField(name="姓名",age = 20)
    String name;
    public Person() {
    }
}



@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTable{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface  MyField{
    String name();
    int age();
}
