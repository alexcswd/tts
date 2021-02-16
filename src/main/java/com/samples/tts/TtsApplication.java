package com.samples.tts;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samples.tts.domain.Comment;
import com.samples.tts.domain.Department;
import com.samples.tts.domain.Task;
import com.samples.tts.domain.User;
import com.samples.tts.repository.CommentRepository;
import com.samples.tts.repository.DepartmentRepository;
import com.samples.tts.repository.TaskRepository;
import com.samples.tts.repository.UserRepository;

@SpringBootApplication
public class TtsApplication {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private CommentRepository commentRepository;

	public static void main(String[] args) {
		SpringApplication.run(TtsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDatastore() {

		User bob = new User("Bob");
		User alice = new User("Alice");
		User claud = new User("Claud");
		
		Department dev = new Department("R&D");
		dev.addEmployee(alice);
		dev.addEmployee(bob);
		
		Department marketing = new Department("Sales");
		marketing.addEmployee(claud);
		
		Task design = new Task("design", "overall application design", bob, bob);
		Comment comment1 = new Comment("let me participate", alice);
		design.addComment(comment1);
		
		Task template = new Task("tempalte", "create the main page's template", bob, alice);
		Comment comment2 = new Comment("Try to use cutting edge technologies", bob);
		template.addComment(comment2);
		
		Task drawIcons = new Task("icons", "draw icons for the main page", alice, alice);
		Comment comment3 = new Comment("You are greate painter!", bob);
		Comment comment4 = new Comment("Thank you!", alice);
		drawIcons.addComment(comment3);
		drawIcons.addComment(comment4);
		
		Task advertise = new Task("adv", "make an advertisement", claud, claud);
		
		return args -> {
			departmentRepository.saveAll(
					Arrays.asList( new Department[] { dev, marketing } ) );
			userRepository.saveAll(
					Arrays.asList(new User[] { bob, alice, claud })
			);
			taskRepository.saveAll(
					Arrays.asList(new Task[] { design, template, drawIcons, advertise })
			);
			commentRepository.saveAll(
					Arrays.asList( new Comment[] { comment1, comment2, comment3, comment4 } )
			);
		};
	}

}
