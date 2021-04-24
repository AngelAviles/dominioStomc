package dominio;

import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {

    protected String uuid;
    protected String datetime;
    protected String requestedBy;
    public MessageType type;
    private Object object;
    
    public Message() {

    }

    public Message(MessageType messageType, String requestedBy){
        this.uuid = UUID.randomUUID().toString();
        this.datetime = String.valueOf(java.time.LocalDateTime.now());
        this.requestedBy = requestedBy;
        this.type = messageType;
    }

    public Message(MessageType type, String requestedBy, Object object) {
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
        SERVER_SUCCESSFULLY_CREATED_TURN,
        
        ADD_EMPLOYEE,
        EDIT_EMPLOYEE,
        DELETE_EMPLOYEE,
        GET_MANY_EMPLOYEE,
        GET_ONE_EMPLOYEE,
        GET_EMPLOYEE_BY_ATTENTION_POINT,
        GET_EMPLOYEE_BY_BRANCH,
        GET_EMPLOYEE_BY_PROFILE,
        LOGIN,
        
        ADD_ATTENTION_POINT,
        EDIT_ATTENTION_POINT,
        DELETE_ATTENTION_POINT,
        GET_MANY_ATTENTION_POINT,
        GET_ONE_ATTENTION_POINT,
        
        ADD_BRANCH,
        EDIT_BRANCH,
        DELETE_BRANCH,
        GET_MANY_BRANCH,
        GET_ONE_BRANCH,
        
        ADD_PROFILE,
        EDIT_PROFILE,
        DELETE_PROFILE,
        GET_MANY_PROFILE,
        GET_ONE_PROFILE,
        
        ADD_TURN,
        EDIT_TURN,
        DELETE_TURN,
        GET_MANY_TURN,
        GET_ONE_TURN,
        GET_TURN_BY_EMPLOYEE,
        
        ADD_LYSING_INFORMATION,
        EDIT_LYSING_INFORMATION,
        DELETE_LYSING_INFORMATION,
        GET_MANY_LYSING_INFORMATION,
        GET_ONE_LYSING_INFORMATION, 
        
        ERROR
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
