package com.raymundo.aequilibrium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.raymundo.aequilibrium.api.TransformerRepository;
import com.raymundo.aequilibrium.model.Transformer;
import com.raymundo.aequilibrium.utilities.Constant;

@SpringBootApplication
public class TransformerswarApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TransformerswarApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	}
	  
	
	@Bean
	public CommandLineRunner saveTransformes(TransformerRepository repository) {
		return (args) -> {
			
			Transformer transformer = null;
			 List<String> namesList = new ArrayList<String>();
			 namesList.add("Bumblebee");
			 namesList.add("Jazz");
			 namesList.add("Ratchet");
			 namesList.add("Starcream");
			 namesList.add("Brawl");
			 namesList.add("Frenzy");
		     Integer counter = 0;
		     
			 for(String name : namesList) {
				 transformer = new Transformer();
				 transformer.setName(name);
				 
				 if(counter>=(Constant.HALF_LIST)) {
					 transformer.setType(Constant.DECEPTICONS_LETTER);
				 }else {
					 transformer.setType(Constant.AUTOBOTS_LETTER);
				 }
				 Random rn = new Random();
				 transformer.setCourage(rn.nextInt(10) + 1);
				 transformer.setEndurance(rn.nextInt(10) + 1);
				 transformer.setFirepower(rn.nextInt(10) + 1);
				 transformer.setIntelligence(rn.nextInt(10) + 1);
				 transformer.setRank(rn.nextInt(10) + 1);
				 transformer.setSpeed(rn.nextInt(10) + 1);
				 transformer.setStrength(rn.nextInt(10) + 1);
				 
//				 Integer skill = transformer.getStrength()+transformer.getIntelligence()+transformer.getSpeed()+transformer.getEndurance()+transformer.getFirepower();
				 transformer.setSkill(rn.nextInt(10) + 1);
				 
				 repository.save(transformer);
				 
				 counter++;
			 }
		};
	}

}
