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
//            System.out.println(response);
            ObjectMapper objectMapper = new ObjectMapper();
            this.idList = objectMapper.readValue(response, new TypeReference<ArrayList<Id>>() {});
            return this.idList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Id postId(Id id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String thisId = objectMapper.writeValueAsString(id);
            String response = transCtrl.MakeURLCall("/ids","POST", thisId);
            getIds();
            System.out.println(response);
            return getIDByGHID(id.getGitHubId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Id putId(String name, String gitHubId) {
        try {
            getIds();
            for (Id id : idList){
                if (id.getGitHubId().equals(gitHubId)){
                    id.setName(name);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String JSONPayload = objectMapper.writeValueAsString(id);
                    transCtrl.MakeURLCall("/ids","PUT", JSONPayload);
                    getIds();
                    return getIDByGHID(id.getGitHubId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;    }

        public Id getIDByGHID(String gitHubID){
            getIds();
            for(Id id : idList){
                if (id.getGitHubId().equals(gitHubID)){
                    return id;
                }
            }
            return null;
        }

}