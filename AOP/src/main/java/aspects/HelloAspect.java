package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
    @Before("execution(* services.HelloService.hello(..))")
    public void before(){
        System.out.println("Before Execution in before");
    }
    @Around("execution(* services.HelloService.hello(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object result = null;
        System.out.println("before execution in around");
        try{
            result = joinPoint.proceed(new Object[]{"Bill"});
            System.out.println("After Execution");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
