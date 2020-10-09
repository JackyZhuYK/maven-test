package com.springlearn.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.springlearn.ch3.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {
}
