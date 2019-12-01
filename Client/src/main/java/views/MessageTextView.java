package views;

import models.Message;

public class MessageTextView {

    Message msgToDisplay;

    public MessageTextView(Message msgToDisplay) {
        this.msgToDisplay = msgToDisplay;
    }
    @Override public String toString() {
        return String.format(
                "*******************************************\n" +
                        "From: %s\n" +
                        "To: %s\n" +
                        "Message: %s\n" +
                        "*******************************************\n\n",
                msgToDisplay.getFromId(), msgToDisplay.getToId(), msgToDisplay.getMessage()
        );
    }

}