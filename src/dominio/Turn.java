package dominio;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Turn implements Serializable {

    private String uuid;
    private String dateTimeCreated;
    private String dateTimeAssigned;
    private String dateTimeFinished;
    private int turnNumber;
    private String status;
    private boolean isActive;
    private Type type;
    private User user;

    public enum Type {
        CAJA,
        MODULO,
        GENERIC
    }

    public Turn() {
    }

    public Turn(Type type){
        this.uuid = UUID.randomUUID().toString();
        this.dateTimeCreated = String.valueOf(java.time.LocalDateTime.now());
        this.status = "En espera";
        this.isActive = true;
        this.type=type;
    }

    public Turn(String uuid, String dateTimeCreated, String dateTimeAssigned, String dateTimeFinished, int turnNumber, String status, boolean isActive, Type type, User user) {
        this.uuid = uuid;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeAssigned = dateTimeAssigned;
        this.dateTimeFinished = dateTimeFinished;
        this.turnNumber = turnNumber;
        this.status = status;
        this.isActive = isActive;
        this.type = type;
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getDateTimeAssigned() {
        return dateTimeAssigned;
    }

    public void setDateTimeAssigned(String dateTimeAssigned) {
        this.dateTimeAssigned = dateTimeAssigned;
    }

    public String getDateTimeFinished() {
        return dateTimeFinished;
    }

    public void setDateTimeFinished(String dateTimeFinished) {
        this.dateTimeFinished = dateTimeFinished;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turn)) return false;
        Turn turn = (Turn) o;
        return Objects.equals(uuid, turn.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "Turn{" +
                "uuid='" + uuid + '\'' +
                ", dateTimeCreated='" + dateTimeCreated + '\'' +
                ", dateTimeAssigned='" + dateTimeAssigned + '\'' +
                ", dateTimeFinished='" + dateTimeFinished + '\'' +
                ", turnNumber=" + turnNumber +
                ", status='" + status + '\'' +
                ", isActive=" + isActive +
                ", type=" + type +
                ", user=" + user +
                '}';
    }
}

