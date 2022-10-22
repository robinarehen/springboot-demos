package co.net.parking.dad.multidatabase.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public OpenEntityManagerInViewFilter parkingOpenEntityManagerInViewFilter() {
		
        OpenEntityManagerInViewFilter inViewFilter = new OpenEntityManagerInViewFilter();
        
        inViewFilter.setEntityManagerFactoryBeanName("parkingEntityManagerFactory");
        
        return inViewFilter;
	}
	
	@Bean
	public OpenEntityManagerInViewFilter beparkingOpenEntityManagerInViewFilter() {
		
        OpenEntityManagerInViewFilter inViewFilter = new OpenEntityManagerInViewFilter();
        
        inViewFilter.setEntityManagerFactoryBeanName("beparkingEntityManagerFactory");
        
        return inViewFilter;
	}
}
