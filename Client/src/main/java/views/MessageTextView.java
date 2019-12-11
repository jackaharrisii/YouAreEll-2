package views;

import models.Message;

import java.util.ArrayList;

public class MessageTextView {

    Message msgToDisplay;

    public MessageTextView(Message msgToDisplay) {
        this.msgToDisplay = msgToDisplay;
    }

    public MessageTextView() {
    }

    @Override public String toString() {
        return String.format(
                "*******************************************\n" +
                        "From: %s\n" +
                        "To: %s\n" +
                        "Message: %s\n" +
                        "*******************************************\n\n",
                msgToDisplay.getFromid(), msgToDisplay.getToid(), msgToDisplay.getMessage()
        );
    }

    public String toString(Message message){
        return new MessageTextView(message).toString();
    }

    public String toString(ArrayList<Message> msgList){
        String output = "";
        for (Message msg : msgList){
            output += new MessageTextView(msg).toString();
        }
        return output;
    }

}