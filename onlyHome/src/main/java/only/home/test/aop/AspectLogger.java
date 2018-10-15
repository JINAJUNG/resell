package only.home.test.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AspectLogger {
	private static final Logger logger = LoggerFactory.getLogger(AspectLogger.class);
	private long sTime;
/*	@Before("execution(* only.home.test.controller.*.*(..))")
	public void beforeLog(JoinPoint jp) {
		logger.debug("jp=>{}",jp);
	}
	*/
	@Around("execution(* only.home.test.controller.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String sigName = pjp.getSignature().getName();
		String targetName = pjp.getTarget().toString();
		Object[] param = pjp.getArgs();
		
		logger.debug("{},{},({})",new Object[] {sigName,targetName,param});
		Object obj = pjp.proceed();
		logger.debug("result -> ",obj);
		return obj;
	}
	
/*	@After("execution(* only.home.test.controller.*.*(..))")
	public void afterLog(JoinPoint jp) {
		logger.debug("af=>{}",jp);
		logger.debug("execution time ->{}ms",(System.currentTimeMillis()-sTime));
	}*/
}
