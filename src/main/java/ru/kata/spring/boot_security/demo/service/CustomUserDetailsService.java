//package ru.kata.spring.boot_security.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import ru.kata.spring.boot_security.demo.model.User;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserService userService;
////
////    @Autowired
////    public CustomUserDetailsService(UserRepository userRepository) {
////        this.userRepository = userRepository;
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findByUserName(username);
//        if(user == null){
//            throw new UsernameNotFoundException("Неизвестый пользователь: " + username);
//        }
//        return org.springframework.security.core.userdetails.User
//                .builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRole())
//                .build();
////        return userDetails;
//    }
//}
