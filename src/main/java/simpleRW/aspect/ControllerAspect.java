package simpleRW.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import simpleRW.dto.CommentReq;

@Aspect
@Component
public class ControllerAspect {

    @Around("@annotation(simpleRW.annotation.CheckBodyIsNull)")
    public Object CheckCommentBodyIsNull(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (Object arg :args) {
            if (arg instanceof CommentReq && ((CommentReq) arg).getBody().equals("")) {
                return "본문을 입력해 주세요.";
            }
        }

        return joinPoint.proceed();
    }
}
