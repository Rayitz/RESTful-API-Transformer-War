package com.raymundo.aequilibrium.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.raymundo.aequilibrium.model.Transformer;
import com.raymundo.aequilibrium.service.TransformerService;

@RequestMapping("/transformer")
@RestController
public class TransformerController {

	
	@Autowired
	private TransformerService sTransformer;
	
    
    @RequestMapping("/create")
    public String createTransformer(@Valid @RequestBody Transformer transformer) {
  	
    	String message = sTransformer.saveUpdateTransformer(transformer);

      return message;
  }
    
    @RequestMapping("/update")
    public String updateTransformer(@Valid @RequestBody Transformer transformer) {
  	
    	String message = sTransformer.saveUpdateTransformer(transformer);

      return message;
  }
    
    @RequestMapping("/list")
    public String listTransformer() {
  	
    	String ratings = sTransformer.getTransformers();

      return ratings;
  }
    
    @RequestMapping("/delete/{idTransformer}")
    public String deleteTranformer(@PathVariable("idTransformer") Integer idTransformer) {
  	
    	
    	String message = sTransformer.deleteTransformer(idTransformer);

      return message;
  }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().stream()
        .map(error -> errors.put(error.getField(), error.getDefaultMessage())).collect(Collectors.toList());
         
        return errors;
    }
}
