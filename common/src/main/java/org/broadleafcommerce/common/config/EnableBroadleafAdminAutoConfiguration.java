/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2017 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.config;

import org.broadleafcommerce.common.extensibility.FrameworkXmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.ServletContainerInitializer;

/**
 * <p>
 * Bootstraps Broadleaf admin configuration XML for both servlet and non-servlet. As a result, this annotation should only be placed
 * on an {@literal @}Configuration class within a servlet. If there are no custom {@link ServletContainerInitializer}s with
 * a servlet-specific {@link ApplicationContext} (like in a non-servlet spring boot application) then this can be placed on the main
 * {@literal @}SpringBootApplication class
 * 
 * <p>
 * Since this annotation is a meta-annotation for {@literal @}ImportResource, this <b>cannot</b> be placed on a {@literal @}Configuration class
 * that contains an {@literal @}ImportResource annotation directly or on a meta-annotation.
 *  
 * <p>
 * This import utilizes the {@link FrameworkXmlBeanDefinitionReader} so that framework XML bean definitions will not
 * overwrite beans defined in a project.
 *
 * @author Philip Baggett (pbaggett)
 * @author Phillip Verheyden (phillipuniverse)
 * @see EnableBroadleafAdminRootAutoConfiguration
 * @see EnableBroadleafAdminServletAutoConfiguration
 * @see EnableBroadleafAutoConfiguration
 * @since 5.2
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ImportResource(locations = {
    "classpath*:/blc-config/bl-*-applicationContext.xml",
    "classpath*:/blc-config/admin/bl-*-applicationContext.xml",
    "classpath*:/blc-config/bl-*-applicationContext-servlet.xml",
    "classpath*:/blc-config/admin/bl-*-applicationContext-servlet.xml"
}, reader = FrameworkXmlBeanDefinitionReader.class)
public @interface EnableBroadleafAdminAutoConfiguration {
}
