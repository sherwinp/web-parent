package org.techlyric;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.techlyric.service.MemberService;

public class TestRun {
	public static void main(String[] args) {
		
        //Create Spring application context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:*/spring-context.xml");

        //Get service from context.
        MemberService memberService = ctx.getBean(MemberService.class);
        
        memberService.findOne("");
        ctx.close();
	}
}
