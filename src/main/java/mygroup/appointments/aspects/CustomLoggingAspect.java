package mygroup.appointments.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import java.util.Arrays;

@Aspect
@Component
public class CustomLoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(CustomLoggingAspect.class);

    // Any method
    @Pointcut("execution(* *.*(..))")
    public void allMethod() {
    }
    //Any class annotated with @Controller
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void controller() {
    }

    //Any class annotated with @Service
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void service() {
    }

    // Measures performance of service layer methods
    // Any method within class annotated with service
    @Around("service() && allMethod()")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        //Measure method execution time
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        //Log method execution time
        LOGGER.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");
        return result;
    }

    //Any method within class annotated with @Controller annotation throwing an exception
    @AfterThrowing(pointcut = "controller() && allMethod()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        LOGGER.info("An exception has been thrown in " + joinPoint.getSignature().getName() + " ()");
        LOGGER.info("Cause : " + exception.getCause());
    }

    // Log all incoming requests to any controller
    @Before("controller() && allMethod()")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Entering in Method :  " + joinPoint.getSignature().getName());
        LOGGER.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        LOGGER.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
        LOGGER.info("Target class : " + joinPoint.getTarget().getClass().getName());
    }

    @AfterReturning(pointcut = "controller() && allMethod()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        LOGGER.info("Method Return value : " + result.toString());
    }

}
