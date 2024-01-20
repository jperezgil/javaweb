///**
// * @author : IT-SECURE - JUAN CARLOS PEREZ GIL
// * @descripción : Objeto AutoLoginFilter
// * @fecha_de_creación : 30-10-2020
// * @fecha_de_ultima_actualización : 30-10-2020
// */
//package edu.cibertec.filter;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletResponse;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.FilterChain;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//import pe.gob.osinergmin.legistrace.common.security.service.SeguridadService;
//
//public class AutoLoginFilter implements Filter {
//
//    private ApplicationContext appContext;
//    private static Logger logger = LoggerFactory.getLogger(AutoLoginFilter.class);
//    private SeguridadService seguridadService = null;
//    private static String MODO_SEG;
//    private static final String PARAM_CHECK_CLIENT_IP = "checkClientIP";
//    private static final String PARAM_CHECK_DATE = "checkDate";
//    private static final String PARAM_INVALID_PARAM_PAGE = "invalidParamPage";
//    private static final String PARAM_INVALID_EXTERN_CALLING_PAGE = "invalidExternCallingPage";
//    private static String invalidParamPage;
//    private static String invalidExternCallingPage;
//    private static boolean checkClientIP;
//    private static boolean checkDate;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        /* INICIO HEADERS DE SEGURIDAD  */
//        logger.info("Inicio validación de Headers");
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//        Cookie[] allCookies = req.getCookies();
//        //        if (allCookies != null) {
//        //            for (Cookie session : allCookies) {
//        //                if (session.getName().equals("JSESSIONID")) {
//        //                    session.setPath("/; SameSite=Lax; secure; HttpOnly");
//        //                    res.addCookie(session);
//        //                    break;
//        //                }
//        //            }
//        //        }
//        //res.setHeader("Content-Type", "text/html; charset=utf-8 ; X-Content-Type-Options=nosniff");
//        res.setHeader("Server", "");
//        if (MODO_SEG.equals("1")) {
//            res.setHeader("Set-Cookie", "JSESSIONID=" + req.getSession().getId() + "; path=/; SameSite=Lax; secure; HttpOnly");
//        }else{
//            res.setHeader("Set-Cookie", "JSESSIONID=" + req.getSession().getId() + "; path=/; SameSite=Lax; HttpOnly");
//        }
//        res.setHeader("Access-Control-Allow-Headers", "Content-Type, X-Requested-With, Cache-Control, X-Authorization, X-XSRF-TOKEN");
//        res.setHeader("X-Frame-Options", "SAMEORIGIN");
//        res.setHeader("Frame-Options", "SAMEORIGIN");
//        res.setHeader("Strict-Transport-Security", "max-age=0; includeSubdomains; preload");
//        res.setHeader("X-UA-Compatible", "IE=edge");
//        res.setHeader("Expires", "-1");
//        res.setHeader("Last-Modified", "-1");
//        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate,  max-age=0");
//        res.setHeader("Pragma", "no-cache");
//        res.setHeader("X-XSS-Protection", "1; mode=block");
//        res.setHeader("X-Content-Type-Options", "nosniff");
//        //res.setHeader("csrf-token", req.getSession().getId());
//        logger.info("Fin validación de Headers");
//        /* FIN HEADERS DE SEGURIDAD  */
//        chain.doFilter(req, res);
//    }
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        appContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
//        checkClientIP = loadBooleanParameter(config, PARAM_CHECK_CLIENT_IP, false);
//        checkDate = loadBooleanParameter(config, PARAM_CHECK_DATE, true);
//        invalidParamPage = config.getInitParameter(PARAM_INVALID_PARAM_PAGE);
//        invalidExternCallingPage = config.getInitParameter(PARAM_INVALID_EXTERN_CALLING_PAGE);
//        seguridadService = (SeguridadService) WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext()).getBean("seguridadService");
//        MODO_SEG = seguridadService.getModoSeg();
//        logger.info("checkClientIP [{}] checkDate [{}] invalidParamPage [{}] invalidExternCallingPage [{}]", new Object[]{checkClientIP, checkDate, invalidParamPage, invalidExternCallingPage});
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//    }
//
//    private boolean loadBooleanParameter(FilterConfig config, String parameterName, boolean defaultValue) {
//        boolean result = defaultValue;
//        String valueString = config.getInitParameter(parameterName);
//        if (valueString != null) {
//            if (valueString.equalsIgnoreCase("true")) {
//                result = true;
//            } else if (valueString.equalsIgnoreCase("false")) {
//                result = false;
//            } else {
//                logger.error("Error al leer el parámetro " + parameterName + ". Deber ser true o false. Se utilizará el valor por defecto: " + defaultValue);
//            }
//        }
//        return result;
//    }
//}
