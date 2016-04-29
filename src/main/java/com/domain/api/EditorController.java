package com.domain.api;

import com.domain.editor.Data;
import com.persistence.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
public class EditorController {

    @Autowired
    EditorRepository editorRepository;

    @RequestMapping(value = "/editor", method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody Map<String, String> data, Principal principal) {
        try {
            Data updatedData = editorRepository.findByUserNameAndIsDeletedAndId(principal.getName(),"false",data.get("id"));
            updatedData.setTitle(data.get("title"));
            updatedData.setText(data.get("data"));
            updatedData.setIsDeleted(data.get("isDeleted"));
            editorRepository.save(updatedData);
        } catch (Exception exp) {
            return new ResponseEntity(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/editor", method = RequestMethod.POST)
    public ResponseEntity<String> post(Principal principal) {
        Data save ;
        try {
            save = editorRepository.save(new Data(principal.getName()));
        } catch (Exception exp) {
            return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<String>(save.getId(),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/editor", method = RequestMethod.GET)
    public List<Data> get(Principal principal) {
        return editorRepository.findByUserNameAndIsDeleted(principal.getName(), "false");
    }

    @RequestMapping(value = "/editor/id", method = RequestMethod.GET)
    public Data getById(@RequestParam String id,Principal principal) {
        return editorRepository.findByUserNameAndIsDeletedAndId(principal.getName(),"false",id);
    }

}
