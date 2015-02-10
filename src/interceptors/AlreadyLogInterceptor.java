package interceptors;

import java.util.Map;



import clases.Usuario;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AlreadyLogInterceptor implements Interceptor {

private static final long serialVersionUID = 1841289944579731267L;

@Override
public void destroy() {
    // TODO Auto-generated method stub

}

@Override
public void init() {
    // TODO Auto-generated method stub

}

@Override
public String intercept(ActionInvocation inv) throws Exception {
    ActionContext context = inv.getInvocationContext();

    //for login
    if(context.getName().equalsIgnoreCase("login") || context.getName().equalsIgnoreCase("register") )
    {
    	Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario user = (Usuario) session.get("usrLogin");
		if (user != null){
			return "login";
		}
			
    }


    return inv.invoke();
    
    
}

}