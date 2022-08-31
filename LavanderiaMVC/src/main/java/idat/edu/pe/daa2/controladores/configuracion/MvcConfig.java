package idat.edu.pe.daa2.controladores.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		
       
        registry.addViewController("/").setViewName("principal");
        registry.addViewController("/principal").setViewName("principal");
        registry.addViewController("/Inicio").setViewName("principal");
        registry.addViewController("/Inicio").setViewName("principal");
        registry.addViewController("/logeo").setViewName("index");
        registry.addViewController("/Login").setViewName("index");
        registry.addViewController("/principal").setViewName("principal");
        registry.addViewController("/error").setViewName("error");
    }


}
