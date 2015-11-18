package mum.edu.shoppingcart.concerns;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CommonConcerns {

	@Before("within (mum.edu.shoppingcart.controller.*)")
	//@Before("execution(public * mum.edu.shoppingcart.controller.*.*(..))")
	//@Before("execution(public * mum.edu.shoppingcart.controller.*.*(..))")
	public void logControllerMethod(JoinPoint point) {
	System.out.println("calling method =" + point.getSignature().getName());

	}

//	@Before("execution (* mum.edu.shoppingcart .controller.*.*(..)) and !args(Model)")
//	public String loginauthentication(JoinPoint point, Model model) {
//		System.out.println("checking method for authenication " + point.getSignature().getName());
//		if (model.asMap().get("customer") == null) {
//			return "redirect:/";
//		}
//		return "";
//	}

}
