package cs.vsu.dao;

import cs.vsu.models.User;

public interface UserDao {
    boolean checkUser(User user);
    User getUser(User name);
}
