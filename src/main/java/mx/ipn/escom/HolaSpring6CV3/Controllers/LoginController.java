package mx.ipn.escom.HolaSpring6CV3.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Carga login.html
    }

    @GetMapping("/redirect")
    public String redirectUser(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return "redirect:/admin"; // Redirige a admin
            } else if (authority.getAuthority().equals("ROLE_USER")) {
                return "redirect:/usuario"; // Redirige a usuario
            }
        }
        return "redirect:/login?error=true"; // En caso de fallo
    }
}
