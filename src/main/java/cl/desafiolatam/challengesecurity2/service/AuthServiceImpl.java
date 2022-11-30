package cl.desafiolatam.challengesecurity2.service;

import cl.desafiolatam.challengesecurity2.mapper.UserMapper;
import cl.desafiolatam.challengesecurity2.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements UserDetailsService {//implementa la interfaz UserDetailsService. Ésta es la Interfaz central para cargar los datos específicos del usuario Se utiliza en todo el marco como acceso a datos del usuario y es una estrategia ampliamente utilizada en el mundo de Spring.


    @Autowired
    private UserMapper userMapper;//Se inyecta el mapper de MyBatis creado anteriormente.

    @Autowired
    private BCryptPasswordEncoder encoder;//Se inyecta el encoder para proteger las contraseñas.

    @Override
    /*En esta implementación propia, se hace la búsqueda en el mapper y se validan las credenciales.
     En caso de no coincidir, se retorna un UsernameNotFoundException, de lo contrario, se siguecon 
     el flujo y se retorna un nuevo objeto con las credenciales correspondientes para ser
    usadas en la configuración de seguridad.*/
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userMapper.findByEmail(email);
        if (users == null) throw new UsernameNotFoundException(email);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(users.getRole().toString()));
        return new User(users.getEmail(),
                users.getPassword(),
                authorities);
    }

}
