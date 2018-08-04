package com.m9i.mappers;

import com.m9i.contents.TaskContent;
import com.m9i.model.Task;
import com.m9i.model.User;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.*;

public class TasksMapperTest {

    private final UUID taskId = UUID.randomUUID();
    private User requester;
    private final UUID requesterId = UUID.randomUUID();
    private final String requesterEmail = "requester@email.com";
    private final String requesterPhone = "111222";
    private User assignee;
    private final UUID assigneeId = UUID.randomUUID();
    private String assigneeEmail = "assignee@email.com";
    private final String assigneePhone = "111222";
    private final String description = "Task Description";
    private final String summary = "Task Summary";
    private final LocalDateTime wishDate = LocalDateTime.now().plusDays(2);

    private Task task;
    private TaskContent taskContent;

    @Before
    public void init() {
        requester = new User();
        requester.setId(requesterId.toString());
        requester.setEmail(requesterEmail);
        requester.setPhoneNumber("111222");

        assignee = new User();
        assignee.setId(assigneeId.toString());
        assignee.setEmail(assigneeEmail);
        assignee.setPhoneNumber(assigneePhone);
    }

    @Test
    public void taskToContentTest() {

        task = new Task();
        task.setRequester(requester);
        task.setAssignee(assignee);
        task.setDescription(description);
        task.setSummary(summary);
        task.setId(taskId.toString());
        task.setWishDate(wishDate);

        TaskContent taskContent = TasksMapper.INSTANCE.taskToContent(task);

        assertEquals(taskId.toString(), taskContent.getId());
        assertEquals(requesterEmail, taskContent.getRequesterEmail());
        assertEquals(assigneeEmail, taskContent.getAssigneeEmail());
        assertEquals(description, taskContent.getDescription());
        assertEquals(summary, taskContent.getSummary());
        assertEquals(wishDate, taskContent.getWishDate());
        assertEquals(requesterId.toString(), taskContent.getRequesterId());
        assertEquals(assigneeId.toString(), taskContent.getAssigneeId());
    }

    @Test
    public void contentToTaskTest() {

        taskContent = new TaskContent();
        taskContent.setId(taskId.toString());
        taskContent.setRequesterId(requesterId.toString());
        taskContent.setRequesterEmail(requesterEmail);
        taskContent.setAssigneeId(assigneeId.toString());
        taskContent.setAssigneeEmail(assigneeEmail);
        taskContent.setDescription(description);
        taskContent.setSummary(summary);
        taskContent.setWishDate(wishDate);

        Task task = TasksMapper.INSTANCE.contentToTask(taskContent);

        assertEquals(taskId.toString(), task.getId());
        assertEquals(requesterEmail, task.getRequester().getEmail());
        assertEquals(assigneeEmail, task.getAssignee().getEmail());
        assertEquals(description, task.getDescription());
        assertEquals(summary, task.getSummary());
        assertEquals(wishDate, task.getWishDate());
        assertEquals(requesterId.toString(), task.getRequester().getId());
        assertEquals(assigneeId.toString(), task.getAssignee().getId());
    }

}