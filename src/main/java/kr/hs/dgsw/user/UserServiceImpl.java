package kr.hs.dgsw.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
        this.setupUsers();
    }

    private void setupUsers() {
        for (int i = 1; i <= 5; i++) {
            users.add(new User(i, "user" + i, "user" + i + "@aa.co.kr"));
        }
    }

    private User findOne(int id) {
        for (User u: users) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getOne(int id) {
        return this.findOne(id);
    }

    @Override
    public boolean add(User user) {
        if (this.findOne(user.getId()) != null) return false;

        users.add(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        User updateUser = this.findOne(user.getId());
        if (updateUser == null) return false;

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        return true;
    }

    @Override
    public boolean delete(int id) {
        User user = this.findOne(id);
        if (user == null) return false;

        users.remove(user);
        return true;
    }
}
