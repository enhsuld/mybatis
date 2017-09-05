package com.macro.dev;

import com.macro.dev.config.CustomUserDetails;
import com.macro.dev.models.LutCmmOrganization;
import com.macro.dev.models.LutRole;
import com.macro.dev.models.LutUser;
import com.macro.dev.repositories.OrgRepository;
import com.macro.dev.repositories.UserRepository;
import com.macro.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizationServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, OrgRepository orep, UserService userService) throws Exception {
        if (repository.count()==0 && orep.count()==0) {
            LutCmmOrganization org = new LutCmmOrganization();
            org.setName("tyder");
            org.setIsactive(true);
            userService.saveOrg(org);
            LutRole rl = new LutRole();
            List<LutRole> roles= Arrays.asList(new LutRole("USER"), new LutRole("ACTUATOR"), new LutRole("ADMIN"));
            userService.save(new LutUser("admin", "adminPassword", org.getId(),roles));
           /* for(LutRole item: roles){
                userService.saveRole(item);
                userService.saveLnkUser(new LnkUserrole(userService.getUser("admin").getId(),item.getId()));
            }*/


        }
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserDetails(repository.findByUsername(username));
    }
}