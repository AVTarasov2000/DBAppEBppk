package cs.vsu.dao;

import cs.vsu.models.BookMark;

public interface BookMarkDao {
    void removeNotById(BookMark bookMark);
}
