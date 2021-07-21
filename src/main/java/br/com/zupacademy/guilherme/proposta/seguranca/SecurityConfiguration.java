package br.com.zupacademy.guilherme.proposta.seguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests ->
		authorizeRequests
				.antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_meu-primeiro-escopo")
				//.antMatchers(HttpMethod.GET, "/proposta/**").permitAll()
				.antMatchers(HttpMethod.GET, "/actuator/prometheus/**").permitAll().anyRequest().authenticated()

		).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	}

}
