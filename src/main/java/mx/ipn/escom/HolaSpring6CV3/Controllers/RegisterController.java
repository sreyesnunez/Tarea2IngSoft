package mx.ipn.escom.HolaSpring6CV3.Controllers;

import mx.ipn.escom.HolaSpring6CV3.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    // Nuevo método para mostrar el formulario de registro
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Muestra el archivo register.html
    }

    // Método POST para procesar el registro
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, Model model) {
        if (userService.registerUser(nombre, email, password)) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "El correo ya está registrado.");
            return "register";
        }
    }

    @PostMapping("/api/register")
    @ResponseBody
    public ResponseEntity<Map<String, String>> apiRegister(@RequestBody Map<String, String> requestData) {
        String nombre = requestData.get("nombre");
        String email = requestData.get("email");
        String password = requestData.get("password");

        Map<String, String> response = new HashMap<>();

        if (userService.registerUser(nombre, email, password)) {
            response.put("message", "Usuario registrado con éxito");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "El correo ya está registrado");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}

