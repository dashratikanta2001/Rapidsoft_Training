package com.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)

@Documented

@Inherited

//@Repeatable(MyAnno.class)
@interface MyAnno
{
	String name();
	String project();
}

@Target(value = { ElementType.LOCAL_VARIABLE, ElementType.METHOD})

@interface MyAnno1
{
	String name();
}
@interface MyAnno3
{
	String name();
}
@interface MyAnno2
{
	String name();
	String project() default"11";
}

//@MyAnno(name="Rati")
@MyAnno(name = "Rati", project = "p1")
@MyAnno2(name = "Rati")
public class UserDefinedAnnotation {

	@MyAnno1(name="Rati")
	public static void main(@MyAnno3(name="Rati") String[] args) {
		// TODO Auto-generated method stub

		@MyAnno1(name="Rati")
		int x;
	}

}
