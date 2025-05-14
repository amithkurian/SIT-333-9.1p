package ontrack_submission.ontrack_submission;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private String studentId;
    private String unitCode;
    private String taskId;
    private String content;
    private String feedback;
    private String status = "Submitted";
    private List<Message> messages = new ArrayList<>();

    public Task(String studentId, String unitCode, String taskId, String content) {
        this.studentId = studentId;
        this.unitCode = unitCode;
        this.taskId = taskId;
        this.content = content;
    }

    // Getters and setters
    public String getStudentId() { return studentId; }
    public String getUnitCode() { return unitCode; }
    public String getTaskId() { return taskId; }
    public String getContent() { return content; }
    public String getFeedback() { return feedback; }
    public String getStatus() { return status; }
    public List<Message> getMessages() { return messages; }

    public void setFeedback(String feedback) { this.feedback = feedback; }
    public void setStatus(String status) { this.status = status; }
    public void addMessage(Message message) { messages.add(message); }
}