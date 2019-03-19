package kr.hs.dgsw.user;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getOne(int id);
    boolean add(User user);
    boolean update(User user);
    boolean delete(int id);
}
