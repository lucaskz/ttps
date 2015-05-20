package aspects;

@Aspect
public class IdiomaAspect {

    @After("execution(* actions.*.*(..))")
    public void doChangeIdioma() {
    	Map<String, Object> session = ActionContext.getContext().getSession();
    	if(session.get("idioma")!=null)
    		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, session.get("idioma"));
    }
}
