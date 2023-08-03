package com.andrecordeiro.todolist;

import com.andrecordeiro.todolist.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoLlistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTaskSuccess() {
		var task = new Task("Tarefa 1", "Desc Tarefa1", false, 1);
		webTestClient.post().uri("/tasks")
				.bodyValue(task)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(task.getName())
				.jsonPath("$[0].description").isEqualTo(task.getDescription())
				.jsonPath("$[0].finished").isEqualTo(task.isFinished())
				.jsonPath("$[0].priority").isEqualTo(task.getPriority());
	}

	@Test
	void testCreateTaskFailure() {

	}

}
