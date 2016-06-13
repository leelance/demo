package com.lance.mq;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javassist.ClassPool;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class GetMethodTest {
	Logger logger = LogManager.getLogger(getClass());

	public String getName(int age, String name) {
		return name;
	}
	
	@Test
	public void main() {
		Class<GetMethodTest> clazz = GetMethodTest.class;
		Method[] methods = clazz.getMethods();
		for(Method method: methods) {
			logger.info("method: {}", method.getName());
			
			if(method.getName().equals("getName")) {
				handlerMethod(method);
			}
			continue;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void handlerMethod(Method method) {
		//返回值类型
		Class returnType = method.getReturnType();
		logger.info("returnType: {}", returnType.getName());
		
		//方法修饰符
		int mod = method.getModifiers();
		logger.info("modifier: {}", Modifier.toString(mod));
		
		//参数类型
		Class[]paramTypes = method.getParameterTypes();
		for(Class paramType: paramTypes) {
			logger.info("paramType: {}", paramType.getName());
		}
		
		try {
			ClassPool pool = ClassPool.getDefault();
			CtMethod ctMethod = pool.getMethod(getClass().getName(), "getName");
			MethodInfo methodInfo = ctMethod.getMethodInfo();
			CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
			LocalVariableAttribute attr = (LocalVariableAttribute)codeAttribute.getAttribute(LocalVariableAttribute.tag);
			
			String[] paramNames = new String[ctMethod.getParameterTypes().length];  
		    int pos = Modifier.isStatic(ctMethod.getModifiers()) ? 0 : 1; 
		    for (int i = 0; i < paramNames.length; i++){
		    	paramNames[i] = attr.variableName(i + pos);
		    }
		    for (String paramName: paramNames) {  
		    	logger.info("paramName: {}", paramName); 
	        }    
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		LocalVariableTableParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
		String[]names = parameterNameDiscoverer.getParameterNames(method);
		for (String name: names) {  
	    	logger.info("LocalVariableTableParameterNameDiscoverer ==> name: {}", name); 
        }  
	}
}