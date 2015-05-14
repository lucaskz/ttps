package aspects;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import clases.Denuncia;
import clases.Mail;
import clases.Mensaje;
import clases.Usuario;


@Aspect
public class MensajeSendAspect {

	
//	@Around("execution(* clasesDAOimpJPA.GenericDAOHibernateJPA.alta(..)) && args(clases.Denuncia))")
	
	//@Around("execution(* clasesDAOimpJPA.DenunciaDAOHibernateJPA.testFunction(..))")
//	@Around("execution(* clasesDAOimpJPA.RecorridoDAOHibernateJPA.denunciar(..))")
//	public Object enviarMailDenuncia(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("logBefore() is running!");
//		 Object result = joinPoint.proceed();
//		   
//		if ((boolean) result) {
//			Object[] args = joinPoint.getArgs();
//			
//			if (((Denuncia) args[1]).getDenunciado() != null) {
//				WebApplicationContext context = WebApplicationContextUtils
//						.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
//
//				Mail mm = (Mail) context.getBean("mailMail");
//				mm.sendMail("li.kaseta@gmail.com", "li_kaseta@hotmail.com",
//						"Nueva denuncia hacia "
//								+ ((Denuncia) args[1]).getDenunciado().getNombre(),
//						"El usuario" + ((Denuncia) args[1]).getDenunciado().getNombre()
//								+ "fue denunciado en un recorrido");
//			}
//		}
//		 return result;
//	}
	@Around("execution(* clasesDAOimpJPA.SolicitudDAOHibernateJPA.solicitar(..))")
	public Object enviarMensajeSolicitud(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result = joinPoint.proceed();
		if(result!=null){
			//envio mensajes de notificacion al creador!
			Object[] args = joinPoint.getArgs();
			Mensaje m = new Mensaje();
			m.setAsunto("¡Nueva solicitud para participar de un recorrido!");
			m.setCreador(((Usuario)args[0]));
			m.setTexto("Tienes una nueva solicitud pendiente de el usuario "+((Usuario)args[0]).getNombre());
			m.setReceptor((Usuario)result);
		}
		return result;
		
	}
	
//	
//	public void enviarMailDenuncia(Denuncia denuncia) throws Throwable {
//		WebApplicationContext context = WebApplicationContextUtils
//				.getRequiredWebApplicationContext(ServletActionContext
//						.getServletContext());
//
//		Mail mm = (Mail) context.getBean("mailMail");
//		mm.sendMail("li.kaseta@gmail.com", "li_kaseta@hotmail.com",
//				"Nueva denuncia hacia "
//						+ denuncia.getDenunciado().getNombre(),
//				"El usuario" + denuncia.getDenunciado().getNombre()
//						+ "fue denunciado en un recorrido");
//	}
	
//	@Before("execution(* *(..))")
//	public void logBefore(JoinPoint joinPoint) {
// 
//		System.out.println("logBefore() is running!");
//		System.out.println("hijacked : " + joinPoint.getSignature().getName());
//		System.out.println("******");
//	}
	
//	@Pointcut("com.xyz.myapp.SystemArchitecture.dataAccessOperation() && args(account,..)")
//	private void accountDataAccessOperation(Account account) {}
	
	
//	@Around("execution(* clasesDAOimpJPA.DenunciaDAOHibernateJPA.alta(..)) && args(clases.Denuncia))")
//	public void enviarMailDenuncia2(ProceedingJoinPoint joinPoint,
//			Denuncia denuncia) throws Throwable {
//		if ((boolean) joinPoint.proceed()) {
//			if (denuncia.getDenunciado() != null) {
//				WebApplicationContext context = WebApplicationContextUtils
//						.getRequiredWebApplicationContext(ServletActionContext
//								.getServletContext());
//
//				Mail mm = (Mail) context.getBean("mailMail");
//				mm.sendMail("li.kaseta@gmail.com", "li_kaseta@hotmail.com",
//						"Nueva denuncia hacia "
//								+ denuncia.getDenunciado().getNombre(),
//						"El usuario" + denuncia.getDenunciado().getNombre()
//								+ "fue denunciado en un recorrido");
//			}
//		}
//	}
}
