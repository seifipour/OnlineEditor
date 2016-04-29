package com.persistence;

import com.domain.editor.Data;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EditorRepository extends MongoRepository<Data,String> {
    List<Data> findByUserNameAndIsDeleted(String username, String isdeleted);
    Data findByUserNameAndIsDeletedAndId(String name, String isdeleted, String id);
}
