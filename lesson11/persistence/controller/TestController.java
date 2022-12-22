package lesson11.persistence.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/test")
public class TestController {

    private final UserDetailsService userDetailsService;

    @GetMapping({"", "/"})
    public String homePage() {
        return "home";
    }

    @GetMapping("/unauthenticated")
    public String unauthenticatedPage() {
        return "unsecured";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/authentication")
    public String userPageAuthentication(Authentication authentication) {
        return "User info: " + authentication.getName() + " authorities: " + authentication.getAuthorities();
    }

    @GetMapping("/principal")
    public String userPagePrincipal(Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        return "User info: " + userDetails.getUsername() + " authorities: " + userDetails.getAuthorities();
    }

}
