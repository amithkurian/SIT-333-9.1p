package ontrack_submission.ontrack_submission;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

public class TaskFeedbackSystemTest {
    
    @Test
    public void testSubmitTask() {
        TaskFeedbackSystem system = new TaskFeedbackSystem();
        system.submitTask("s123456", "SIT123", "Task1", "Portfolio content");
        
        List<Task> tasks = system.getStudentTasks("s123456");
        assertEquals(1, tasks.size());
        assertEquals("SIT123", tasks.get(0).getUnitCode());
    }
    
    @Test
    public void testAddFeedback() {
        TaskFeedbackSystem system = new TaskFeedbackSystem();
        system.submitTask("s123456", "SIT123", "Task1", "Content");
        system.addFeedback("s123456", "SIT123", "Task1", "Good work but needs more references");
        
        Task task = system.getStudentTasks("s123456").get(0);
        assertEquals("Good work but needs more references", task.getFeedback());
    }
    
    @Test
    public void testAddMessage() {
        TaskFeedbackSystem system = new TaskFeedbackSystem();
        system.submitTask("s123456", "SIT123", "Task1", "Content");
        system.addMessage("s123456", "SIT123", "Task1", "tutor1", "Can you clarify requirement 3?");
        system.addMessage("s123456", "SIT123", "Task1", "s123456", "Yes, I need help with that part");
        
        Task task = system.getStudentTasks("s123456").get(0);
        assertEquals(2, task.getMessages().size());
        assertEquals("tutor1", task.getMessages().get(0).getSender());
    }
    
    @Test
    public void testGetTaskStatus() {
        TaskFeedbackSystem system = new TaskFeedbackSystem();
        system.submitTask("s123456", "SIT123", "Task1", "Content");
        assertEquals("Submitted", system.getTaskStatus("s123456", "SIT123", "Task1"));
        
        system.addFeedback("s123456", "SIT123", "Task1", "Feedback");
        assertEquals("Feedback Provided", system.getTaskStatus("s123456", "SIT123", "Task1"));
    }
}