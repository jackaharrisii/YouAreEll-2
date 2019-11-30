package controllers;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;

public class IdController {
    Id myId;
    private TransactionController transCtrl;
    private ArrayList<Id> idList;

    public IdController(TransactionController transCtrl) {
        this.transCtrl = transCtrl;
    }

    public ArrayList<Id> getIds(){
        try {
            String response = transCtrl.MakeURLCall("/ids", "GET", "");
            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            this.idList = objectMapper.readValue(response, new TypeReference<ArrayList<Id>>() {});
            return this.idList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Id postId(Id id) {
        return null;
    }

    public Id putId(Id id) {
        return null;
    }

}