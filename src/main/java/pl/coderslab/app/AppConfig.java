package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.converter.ArticleConverter;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean
    ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public	void	configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer)	{
        configurer.enable();
    }
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory()	{
        LocalEntityManagerFactoryBean	emfb	=	new	LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("defaultConfig");
        return	emfb;	}
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf)	{
        JpaTransactionManager	tm	=	new	JpaTransactionManager(emf);
        return	tm;	}
    @Override
    public	void	addFormatters(FormatterRegistry registry)	{
        registry.addConverter(getArticleConverter());
    }
    @Bean
    public ArticleConverter getArticleConverter()	{
        return	new ArticleConverter();
    }
}
