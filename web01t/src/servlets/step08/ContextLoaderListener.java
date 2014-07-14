package servlets.step08;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

// => DAO 및 SqlSessionFactory 객체도 ServletContext에 보관한다.
// => setter 메서드를 찾아서 호출한다.

public class ContextLoaderListener implements ServletContextListener {
  static Logger logger = Logger.getLogger(ContextLoaderListener.class);
  ServletContext ctx;
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    logger.debug("contextInitialized 호출됨...");
    try {
      ctx = event.getServletContext();
      
      prepareMyBatis();
      
      String[] classnames = getClassNames();
      
      prepareObjects(classnames);
      
      prepareDependancies();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void prepareMyBatis() throws IOException {
    String resource = "servlets/step08/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    ctx.setAttribute("sqlSessionFactory", sqlSessionFactory);
  }

  private String[] getClassNames() throws Exception {
    logger.debug(ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
    File classDir = new File(
        ctx.getRealPath("/WEB-INF/classes/servlets/step08"));
    
    return classDir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".class")) return true;
        else return false;
      }
    });
  }
  
  private void prepareObjects(String[] classnames) throws Exception {
    Class<?> clazz = null;
    Object instance = null;
    Component compAnno = null;
    
    for (String classname : classnames) {
      clazz = loadClass(classname);
      compAnno = getComponentAnnotation(clazz);
      if (compAnno != null) {
        instance = createInstance(clazz);
        ctx.setAttribute(compAnno.value(), instance);
      }
    }
  }
  
  private void prepareDependancies() throws Exception {
    Enumeration<String> instanceNames = ctx.getAttributeNames();
    Object instance = null;
    
    String instanceName = null;
    while (instanceNames.hasMoreElements()) {
      instanceName = instanceNames.nextElement();
      instance = ctx.getAttribute(instanceName);
      
      injectDependancy(instance);
    }
  }

  private void injectDependancy(Object instance) throws Exception {
    Method[] methods = instance.getClass().getMethods();
    Object dependancy = null;
    for (Method method : methods) {
      if (method.getName().startsWith("set")
          && method.getParameterCount() == 1) { //setter 메서드인 경우
        logger.debug(instance.getClass().getSimpleName() + ":" + method.getName());
        
        dependancy = findDependancyFromServletContext(
            method.getParameterTypes()[0]);
        
        if (dependancy != null) { // setter 메서드의 의존 객체를 찾았다면, setter 호출!
          logger.debug(method.getName() + " 호출");
          method.invoke(instance, dependancy);
        }
      }
    }
  }
  
  private Object findDependancyFromServletContext(Class<?> clazz) {
    logger.debug("파라미터 찾기 => " + clazz.getSimpleName() + " 타입 인스턴스");
    Enumeration<String> instanceNames = ctx.getAttributeNames();
    Object instance = null;
    
    String instanceName = null;
    while (instanceNames.hasMoreElements()) {
      instanceName = instanceNames.nextElement();
      instance = ctx.getAttribute(instanceName);
      if (instance != null && clazz.isInstance(instance)) {
        return instance;
      }
    }
    
    return null;
  }
  
  private Object createInstance(Class<?> clazz) throws InstantiationException,
      IllegalAccessException {
    Object instance = clazz.newInstance();
    logger.debug("     " + clazz.getSimpleName() + " 인스턴스 생성됨");
    return instance;
  }

  private Component getComponentAnnotation(Class<?> clazz) {
    return (Component)clazz.getAnnotation(Component.class);
  }

  private Class<?> loadClass(String classname) throws ClassNotFoundException {
    Class<?> clazz = Class.forName("servlets.step08." + 
        classname.substring(0, classname.indexOf('.')) );
    logger.debug("==>" + clazz.getName());
    return clazz;
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {
    logger.debug("contextDestroyed 호출됨...");
  }
}












