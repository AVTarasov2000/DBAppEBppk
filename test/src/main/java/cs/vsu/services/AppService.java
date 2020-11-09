package cs.vsu.services;

import cs.vsu.dto.AuthorDTO;

import java.util.List;

public interface AppService {
    public List <AuthorDTO> getAllAuthors();
}
