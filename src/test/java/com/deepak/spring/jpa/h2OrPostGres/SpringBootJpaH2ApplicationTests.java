package com.deepak.spring.jpa.h2OrPostGres;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.deepak.spring.jpa.h2OrPostGres.controller.TutorialController;
import com.deepak.spring.jpa.h2OrPostGres.model.Tutorial;
import com.deepak.spring.jpa.h2OrPostGres.repository.TutorialRepository;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {

	  @Mock
	 private TutorialRepository tutorialRepository;
	  //When using Mockito Use @InjectMocks to inject
	  //Mocked beans to following class
	  
	    @Test 
	  void getAllPerson()
	    {
	      //given
	       Tutorial person= new Tutorial("qqq", "dd", false);
	       Tutorial person1= new Tutorial("qqq", "dd", false);
	      //When
	    
	      var  personList = tutorialRepository.findByTitleContainingIgnoreCase("444ff");
	       //Then
	    //Make sure to import assertThat From org.assertj.core.api package
	         assertThat(personList).isNotNull();
	        
	  }
	}
