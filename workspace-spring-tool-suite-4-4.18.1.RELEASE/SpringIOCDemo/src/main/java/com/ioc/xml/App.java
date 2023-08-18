package com.ioc.xml;
import com.ioc.xml.model.Employee;
import com.ioc.xml.model.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
//        Employee eobj=new Employee(1001,"Tim",23);
//        Address aobj=new Address(1,"Tim","India");
//        System.out.println(eobj);
//        System.out.println(aobj);
    	ApplicationContext apctext=new ClassPathXmlApplicationContext("beans.xml");
    	Employee eobj=apctext.getBean("empObj",Employee.class);
    	Address aobj=apctext.getBean("addObj",Address.class);
    	System.out.println(eobj);
    	System.out.println(aobj);
    }
}
