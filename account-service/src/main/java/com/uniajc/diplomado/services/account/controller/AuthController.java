package com.uniajc.diplomado.services.account.controller;

/**
 * Created by Anjulog on 2019-10-11.
 * com.shaft.controller
 * Shaft
 *  *
 * the name of the current project
 */

import com.uniajc.diplomado.services.account.entity.Rol;
import com.uniajc.diplomado.services.account.entity.User;
import com.uniajc.diplomado.services.account.enums.RolNames;
import com.uniajc.diplomado.services.account.security.jwt.JwtProvider;
import com.uniajc.diplomado.services.account.service.RolService;
import com.uniajc.diplomado.services.account.service.UserService;
import com.uniajc.diplomado.services.account.dto.JwtDTO;
import com.uniajc.diplomado.services.account.dto.LoginUser;
import com.uniajc.diplomado.services.account.dto.Message;
import com.uniajc.diplomado.services.account.dto.SignUpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping ("/api/auth")
@CrossOrigin (origins = "*")
public class AuthController
{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping ("/new")
    public ResponseEntity<?> nuevo (@Valid @RequestBody SignUpUser newUser, BindingResult bindingResult)
    {
        if ( bindingResult.hasErrors () )
            return new ResponseEntity (new Message ("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if ( userService.existsByLogin ( (newUser.getLogin ()) ))
            return new ResponseEntity (new Message ("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if ( userService.existsByEmail (newUser.getEmail ()) )
            return new ResponseEntity (new Message ("ese email ya existe"), HttpStatus.BAD_REQUEST);
        User user = new User (newUser.getNameUser (), newUser.getLogin (),
                              newUser.getEmail (), passwordEncoder.encode (newUser.getPassword ()));
        Set<String> rolesStr = newUser.getRoles ();
        Set<Rol> roles = new HashSet<> ();
        for (String rol : rolesStr)
        {
            switch (rol)
            {
                case "admin":
                    Rol rolAdmin = rolService.getByRolNames (RolNames.ROLE_ADMIN).get ();
                    roles.add (rolAdmin);
                    break;
                default:
                    Rol rolUser = rolService.getByRolNames (RolNames.ROLE_USER).get ();
                    roles.add (rolUser);
            }
        }
        user.setRoles (roles);
        userService.storage (user);
        return new ResponseEntity (new Message ("user guardado"), HttpStatus.CREATED);
    }

    @PostMapping ("/login")
    public ResponseEntity<JwtDTO> login (@Valid @RequestBody LoginUser loginUsuario, BindingResult bindingResult)
    {
        if ( bindingResult.hasErrors () )
            return new ResponseEntity (new Message ("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate (
                new UsernamePasswordAuthenticationToken (loginUsuario.getLogin (), loginUsuario.getPassword ()));
        SecurityContextHolder.getContext ().setAuthentication (authentication);
        String jwt = jwtProvider.generateToken (authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal ();
        JwtDTO jwtDTO = new JwtDTO (jwt, userDetails.getUsername (), userDetails.getAuthorities ());
        return new ResponseEntity<JwtDTO> (jwtDTO, HttpStatus.OK);
    }
}
