package cs.vsu.dao;

public interface AuthorDao {
    void deleteByName(String name);
    void updateByName(String prewName, String name);

}
