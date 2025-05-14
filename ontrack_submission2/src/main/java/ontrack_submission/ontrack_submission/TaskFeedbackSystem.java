package ontrack_submission.ontrack_submission;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskFeedbackSystem {
    private List<Task> tasks = new ArrayList<>();
    
    public void submitTask(String studentId, String unitCode, String taskId, String content) {
        Task task = new Task(studentId, unitCode, taskId, content);
        tasks.add(task);
    }
    
    public List<Task> getStudentTasks(String studentId) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStudentId().equals(studentId)) {
                result.add(task);
            }
        }
        return result;
    }
    
    public void addFeedback(String studentId, String unitCode, String taskId, String feedback) {
        Task task = findTask(studentId, unitCode, taskId);
        task.setFeedback(feedback);
        task.setStatus("Feedback Provided");
    }
    
    public void addMessage(String studentId, String unitCode, String taskId, 
                         String sender, String message) {
        Task task = findTask(studentId, unitCode, taskId);
        task.addMessage(new Message(sender, message, LocalDateTime.now()));
    }
    
    public String getTaskStatus(String studentId, String unitCode, String taskId) {
        return findTask(studentId, unitCode, taskId).getStatus();
    }
    
    private Task findTask(String studentId, String unitCode, String taskId) {
        for (Task task : tasks) {
            if (task.getStudentId().equals(studentId) && 
                task.getUnitCode().equals(unitCode) && 
                task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }
}