package com.raymundo.aequilibrium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymundo.aequilibrium.bean.TransformerBean;
import com.raymundo.aequilibrium.service.WarTransformerService;

@RestController
public class WarTransformersController {

	
	@Autowired
	private WarTransformerService warService;

    @RequestMapping("/war")
    public String getMovieByName(@RequestBody TransformerBean transformer) {
    	
    	String dataMovie = null;
    	
    	dataMovie = warService.startWar(transformer.getTransformersForWar());
    	
        return dataMovie;
    }
    
    
    
}
