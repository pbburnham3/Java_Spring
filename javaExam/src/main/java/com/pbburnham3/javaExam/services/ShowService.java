package com.pbburnham3.javaExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pbburnham3.javaExam.models.Show;
import com.pbburnham3.javaExam.repositories.ShowRepository;

@Service
public class ShowService {
 // adding the show repository as a dependency
	private final ShowRepository showRepository;
 
	public ShowService(ShowRepository showRepository) {
	    this.showRepository = showRepository;
	}
	
	// returns all the shows
	public List<Show> allShows() {
	    return showRepository.findAll();
	}
	
	// creates a show
	public Show createShow(Show b) {
	    return showRepository.save(b);
	}
	
	// retrieves a show
	public Show findShow(Long id) {
	    Optional<Show> optionalShow = showRepository.findById(id);
	    if(optionalShow.isPresent()) {
	        return optionalShow.get();
	    } else {
	        return null;
	    }
	}
	
	public Show updateShow(Show show) {
		
		return showRepository.save(show);
	}
	
	// deletes a show
	public Show deleteShow(Long id) {
		showRepository.deleteById(id);
		return null;
	}

	
}