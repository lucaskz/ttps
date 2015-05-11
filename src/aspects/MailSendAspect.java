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


@Aspect
public class MailSendAspect {

	
//	@Around("execution(* clasesDAOimpJPA.GenericDAOHibernateJPA.alta(..)) && args(clases.Denuncia))")
	
	//@Around("execution(* clasesDAOimpJPA.DenunciaDAOHibernateJPA.testFunction(..))")
	@Around("execution(* clases.Recorrido.addDenuncia(..))")
	public void enviarMailDenuncia(ProceedingJoinPoint joinPoint) throws Throwable {
		if ((boolean) joinPoint.proceed()) {
			joinPoint.getArgs();
//			if (denuncia.getDenunciado() != null) {
				WebApplicationContext context = WebApplicationContextUtils
						.getRequiredWebApplicationContext(ServletActionContext.getServletContext());

				Mail mm = (Mail) context.getBean("mailMail");

//			}
		}
	}
	
	public void enviarMailDenuncia(Denuncia denuncia) throws Throwable {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext
						.getServletContext());

		Mail mm = (Mail) context.getBean("mailMail");
		mm.sendMail("li.kaseta@gmail.com", "li_kaseta@hotmail.com",
				"Nueva denuncia hacia "
						+ denuncia.getDenunciado().getNombre(),
				"El usuario" + denuncia.getDenunciado().getNombre()
						+ "fue denunciado en un recorrido");
	}
	
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
