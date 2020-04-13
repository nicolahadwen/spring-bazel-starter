package co.hadwen.web.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * Web security configuration
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfig = new CorsConfiguration();
        // todo: make env variable
        corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:8081"));
        corsConfig.setAllowedMethods(
                Arrays.asList(
                        RequestMethod.GET.name(),
                        RequestMethod.POST.name(),
                        RequestMethod.DELETE.name(),
                        RequestMethod.OPTIONS.name(),
                        RequestMethod.PATCH.name()));
        corsConfig.addAllowedHeader("*");
        corsConfig.addExposedHeader(ExposedHeaders.LOCATION.getFormattedName());
        corsConfig.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        http.cors().configurationSource(source)
                .and()
                //todo: figure out what this is.
                .csrf()
                .disable();
    }


    @AllArgsConstructor
    @Getter
    enum ExposedHeaders {
        LOCATION("location");
        private final String formattedName;
    }
}
