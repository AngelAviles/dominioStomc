package dominio;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {

    protected String uuid;
    protected String datetime;
    protected String requestedBy;
    public MessageType type;
    private Object object;

    public Message(MessageType messageType, String requestedBy){
        this.uuid = UUID.randomUUID().toString();
        this.datetime = String.valueOf(java.time.LocalDateTime.now());
        this.requestedBy = requestedBy;
        this.type = messageType;
    }

    public Message() {

    }

    public Message(String requestedBy, MessageType type, Object object) {
        this.uuid = UUID.randomUUID().toString();;
        this.datetime = String.valueOf(java.time.LocalDateTime.now());
        this.requestedBy = requestedBy;
        this.type = type;
        this.object = object;
    }
    
    

    public enum MessageType {
        NEW_TURN_CAJA,
        NEW_TURN_MODULO,
        NEW_TURN_GENERIC,
        CALL_NEXT_CAJA,
        CALL_NEXT_MODULO,
        CALL_NEXT_GENERIC,
        RELEASE_TURN,
        SERVER_SUCCESSFULLY_CREATED_TURN
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    
    
}
