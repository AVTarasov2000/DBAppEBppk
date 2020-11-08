package cs.vsu.services;

import cs.vsu.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO findUser(int id);

    public void saveUser(UserDTO user);

    public void deleteUser(UserDTO user);

    public void updateUser(UserDTO user);

    public List <UserDTO> findAllUsers();

}
