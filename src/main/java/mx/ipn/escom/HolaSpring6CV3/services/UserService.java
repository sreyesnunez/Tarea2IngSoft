package mx.ipn.escom.HolaSpring6CV3.services;

import mx.ipn.escom.HolaSpring6CV3.models.Usuario;
import mx.ipn.escom.HolaSpring6CV3.models.Rol;
import mx.ipn.escom.HolaSpring6CV3.repositories.UserRepository;
import mx.ipn.escom.HolaSpring6CV3.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public boolean registerUser(String nombre, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return false; // Usuario ya existe
        }

        // Encriptar la contraseña antes de guardarla
        String hashedPassword = passwordEncoder.encode(password);

        Usuario newUser = new Usuario(nombre, email, hashedPassword);

        // Asignar rol USER por defecto
        Rol roleUser = roleRepository.findByNombre("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("El rol ROLE_USER no existe en la BD."));

        newUser.setRoles(Collections.singleton(roleUser));

        userRepository.save(newUser);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword()) // La contraseña ya está encriptada en la BD
                .authorities(usuario.getRoles().stream()
                        .map(Rol::getNombre) // Spring Security usa roles con "ROLE_"
                        .collect(Collectors.toList())
                        .toArray(new String[0]))
                .build();
    }
}
