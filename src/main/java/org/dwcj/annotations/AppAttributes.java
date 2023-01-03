package org.dwcj.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotates a class to set multiple attributes on the document element of the
 * web page.
 * 
 * <p>
 * By default, setAttribute applies to the <a href=
 * "https://developer.mozilla.org/en-US/docs/Web/API/Document/documentElement">document</a>
 * element on the web page. If a selector is specified, it selects a descendant
 * element within the document to set this attribute.
 * If a specified <a href=
 * "https://developer.mozilla.org/en-US/docs/Web/API/Document/querySelector">selector</a>
 * doesn't return any elements, the
 * default document element is used.
 * <p>
 * 
 * The annotation can be used on the class level only and the class must extend
 * `org.dwcj.App` in order for the annotation to be processed.
 * 
 * <pre>
 * {@code
 * &#64;AppAttributes({
 *  &#64;AppAttribute(name = "first-attr", value = "value1"),
 *  &#64;AppAttribute(name = "second-attr", value = "value2", selector = "body")
 * })
 * }
 * </pre>
 * 
 * @see AppAttribute
 * @Author Hyyan Abo Fakher
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AppAttributes {
  AppAttribute[] value();
}
