package com.ispan.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkMessagesDao extends JpaRepository<WorkMessages, Integer> {
	public WorkMessages findFirstByOrderByAddedDesc();
}
