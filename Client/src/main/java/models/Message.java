package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/*
 * POJO for an Message object
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    String sequence;
    Date timestamp;
    String message;
    String fromid;
    String toid;

    public Message (){}

    public Message (String toid, String fromid, String message) {
        this.message = message;
        this.fromid = fromid;
        this.toid = toid;
        this.sequence = "-";
        this.timestamp = null;
    }

    public Message (String sequence, Date timestamp, String fromid, String toid, String message){
        this.message = message;
        this.fromid = fromid;
        this.toid = toid;
        this.sequence = sequence;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}