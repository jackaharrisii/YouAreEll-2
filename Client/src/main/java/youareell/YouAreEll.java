package youareell;

import controllers.*;
import models.Id;
import models.Message;
import views.IdTextView;
import views.MessageTextView;

public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    private TransactionController transCtrl;
    private Id fromID;
    private Id toID;
    private Message messageToSend;

    public YouAreEll () {
        // used j because i seems awkward
        this.transCtrl = new TransactionController();
        this.idCtrl = new IdController(transCtrl);
        this.msgCtrl = new MessageController(transCtrl);
    }

//    public static void main(String[] args) {
//        // hmm: is this Dependency Injection?
//        YouAreEll urlhandler = new YouAreEll();
////        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
////        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
//    }

    public String get_ids() {
//        return MakeURLCall("/ids", "GET", "");
        return new IdTextView().toString(idCtrl.getIds());
    }

    public String setCurrent (String gitHubId){
        for (Id dbID : idCtrl.getIds()){
            if (gitHubId.equals(dbID.getGitHubId())){
                System.out.println("\n" +
                        "\n\n*******************************************\n" +
                        "The below GitHub ID is now your current ID:");
                return new IdTextView().toString(idCtrl.makeIdCurrent(dbID));
            }
        }
        return "That ID is not in the current database. Please select another.";
    }

    public String getCurrent (){
        System.out.println("\n\n");
        if (idCtrl.getMyId() != null) {
            return new IdTextView().toString(idCtrl.getMyId());
        }
        else return "There is no current ID set in the system yet.\n" +
                "Use the command \"ids setCurrent [your ID]\" to set the current ID.";
    }

    public String putOrPostId(String name, String gitHubId){
        for (Id dbID : idCtrl.getIds()){
            if (gitHubId.equals(dbID.getGitHubId())){
                idCtrl.putId(name, gitHubId);
                return new IdTextView().toString(idCtrl.getIDByGHID(gitHubId));
            }
        }
        Id newID = new Id(name, gitHubId);
        idCtrl.postId(newID);
        return idCtrl.getIDByGHID(gitHubId).toString();
    }

    public String get_messages() {
        return new MessageTextView().toString(this.msgCtrl.getMessages());
//        return MakeURLCall("/messages", "GET", "");
//        return null;
    }

    public String sendMessage(String you, String me, String messageBody){
        if (me.equals("")) me = getCurrent();
        messageToSend = new Message(me, you, messageBody);
        fromID = idCtrl.getIDByGHID(me);
        if (idCtrl.getIDByGHID(you) == null || you.equals("")){
            //send the message "to the world", whatever that means
        }
//        else if (idCtrl.getIDByGHID(you) != null) {
        else {
            toID = idCtrl.getIDByGHID(you);
        }
        return new MessageTextView().toString(msgCtrl.postMessage(fromID, toID, messageToSend));
    }

}
