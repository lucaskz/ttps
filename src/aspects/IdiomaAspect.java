package aspects;

import java.util.Map;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

@Aspect
public class IdiomaAspect  {

    @After("execution(* actions.*.*(..))")
    public void doChangeIdioma() throws Throwable {
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	if(session.get("idioma")!=null)
    		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, session.get("idioma"));
    }
}
