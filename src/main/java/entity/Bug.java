package entity;

import java.util.UUID;

public class Bug {

    private UUID uuid;
    private String summary;
    private String description;
    private Priority priority;
    private Severity severity;
    private String assignedTo;
    private Status status;
    private String expectedResult;
    private String actualResult;

    public Bug(String summary, String description, Priority priority, Severity severity, String assignedTo,
               String expectedResult, String actualResult) {
        this.uuid = UUID.randomUUID();
        this.summary = summary;
        this.description = description;
        this.priority = priority;
        this.severity = severity;
        this.assignedTo = assignedTo;
        this.status = Status.NEW;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }
}
