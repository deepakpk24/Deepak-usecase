package com.deepak.spring.jpa.h2OrPostGres.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.spring.jpa.h2OrPostGres.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByPublished(boolean published);

  List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
