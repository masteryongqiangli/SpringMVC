package system.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	/**
	 * 操作类型，默认为0
	 * @return
	 */
	public int operationType() default - 1;
	/**
	 * 操作名称,默认空白
	 * @return
	 */
	public String operationName() default "";
}
