package lesson2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//这也是main分支改的东西
public class TestAnnotion {
    public static void main(String[] args) {

    }

    @MyAnootion(value = {"123", "sdsad"})
    public void get() {

    }
}

@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnootion {
    String[] value();
}
