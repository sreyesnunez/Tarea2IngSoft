package mx.ipn.escom.HolaSpring6CV3.Controllers;

import mx.ipn.escom.HolaSpring6CV3.models.Usuario;
import mx.ipn.escom.HolaSpring6CV3.repositories.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UsuarioController {

    private final UserRepository userRepository;

    public UsuarioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/usuario")
    public String usuarioPerfil(@AuthenticationPrincipal User user, Model model) {
        // Buscar al usuario autenticado en la BD
        Optional<Usuario> usuarioOptional = userRepository.findByEmail(user.getUsername());

        if (usuarioOptional.isPresent()) {
            model.addAttribute("usuario", usuarioOptional.get());
        } else {
            return "redirect:/login?error=user_not_found";
        }

        return "usuario"; // Carga usuario.html con los datos correctos
    }
}
