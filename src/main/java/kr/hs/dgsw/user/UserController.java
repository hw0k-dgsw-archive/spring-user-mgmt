package kr.hs.dgsw.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public @ResponseBody List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public @ResponseBody User getOne(@PathVariable String id) {
        return userService.getOne(Integer.parseInt(id));
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public boolean add(@RequestBody User user) throws Exception {
        return userService.add(user);
    }

    @PutMapping(value = "/user", consumes = "application/json")
    public boolean update(@RequestBody User user) throws Exception {
        return userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable String id) {
        return userService.delete(Integer.parseInt(id));
    }
}
