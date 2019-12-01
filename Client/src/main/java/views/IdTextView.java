package views;

import models.Id;

import java.util.ArrayList;

public class IdTextView {

    Id idToDisplay;

    public IdTextView(Id idToDisplay) {
        this.idToDisplay = idToDisplay;
    }

    public IdTextView(){
    }

    @Override public String toString() {
        return String.format(
                "******************************************\n" +
                "Name: %s\n" +
                "GitHub ID: %s\n" +
                "******************************************\n\n",
                idToDisplay.getName(), idToDisplay.getGitHubId());
    }

    public String toString(Id id){
        return new IdTextView(id).toString();
    }

    public String toString(ArrayList<Id> idList){
        String output = "";
        for(Id id : idList){
            output += new IdTextView(id).toString();
        }
        return output;
    }

}