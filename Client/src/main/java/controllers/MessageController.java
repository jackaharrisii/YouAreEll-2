package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private TransactionController transCtrl;
    private ArrayList<Message> msgList = new ArrayList<>();

    public MessageController(TransactionController transCtrl){
        this.transCtrl = transCtrl;
    }

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {
        try {
            String response = transCtrl.MakeURLCall("/messages", "GET", "");
            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            Community c = objectMapper.readValue(JSON, Community.class);
            this.msgList = objectMapper.readValue(response, new TypeReference<ArrayList<Message>>() {});
            return this.getMsgList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        return null;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        String you;
        String me;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            if (toId != null) {
                you = toId.getGitHubId();
            }
            else {you = "";}
            String thisMessage = objectMapper.writeValueAsString(msg);
            String response = transCtrl.post(String.format("/ids/%s/messages",myId.getGitHubId()), thisMessage);
//            getIds();
            System.out.println(response);
//            return objectMapper.readValue(response, Message.class);   // GO BACK AND UPDATE THIS TO GET THE LAST MESSAGE SENT ONCE THAT FUNCTIONALITY IS BUILT
            JSONObject jsonObject = new JSONObject(response);
            return new Message(jsonObject.get("message").toString(), jsonObject.get("fromid").toString(), jsonObject.get("toid").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Message> getMsgList() {
        return msgList;
    }
}