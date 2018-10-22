package org.sft.sample.web.project.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对项目、项目环境以及项目配置项的操作
 * 
 * @author sunft
 *
 */
@RestController
@RequestMapping("/project")
public class ProjectConfigController {
	@PostMapping("/project")
	private int addProject() {
		return 0;
	}
	@DeleteMapping("/project")
	private int deleteProject(String projectId) {
		return 0;
	}
}
