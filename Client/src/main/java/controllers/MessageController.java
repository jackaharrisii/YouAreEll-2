package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;

public class MessageController {
    private TransactionController transCtrl;

    public MessageController(TransactionController transCtrl){
        this.transCtrl = transCtrl;
    }

    private HashSet<Message> messagesSeen;
    // why a HashSet??

    public ArrayList<Message> getMessages() {
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
 
}