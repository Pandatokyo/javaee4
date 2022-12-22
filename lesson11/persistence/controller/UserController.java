package lesson11.persistence.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lesson11.persistence.entities.User;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String editUsersList() {
        return "Список пользователей";
    }

    @GetMapping("/edit/{userId}")
    public String editUser(@PathVariable Long userId) {
        return "Изменение данных пользователя по id";
    }

    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createUser(@RequestBody User user) {
        return "Создание пользователя " + user.getUsername() + " " + user.getEmail();

    }

    @PutMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody User user) {
        return "Изменение данных пользователя по почте и паролю ";
    }

    @DeleteMapping(value = "/edit/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable Long userId) {
        return "Удаление данных о пользователе по id";
    }
}
