package com.raymundo.aequilibrium.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raymundo.aequilibrium.api.TransformerRepository;
import com.raymundo.aequilibrium.bean.MessageBean;
import com.raymundo.aequilibrium.model.Transformer;
import com.raymundo.aequilibrium.utilities.Constant;
import com.raymundo.aequilibrium.utilities.Utilities;

@Service

public class WarTransformerService {

	@Autowired
	private TransformerRepository rTransformer;
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@SuppressWarnings("unused")
	public String startWar(List<Long> idsTransformer) {
		
	MessageBean messageBean = new MessageBean();
	String message = null;

     List<Transformer> listTransformers = rTransformer.findAllById(idsTransformer);
     
//     for(Transformer data : listTransformers) {
//			logger.info("initial list" + data.getName()+" tipo : "+data.getType()+" firepower : "+data.getFirepower()+
//			" courage : "+data.getCourage()+" endurance : "+data.getEndurance()+" inteligence : "+data.getIntelligence()
//			+" rank : "+data.getRank()+" skill : "+data.getSkill()+" speed : "+data.getSpeed()+" strength : "+data.getStrength());
//     }
     
     List<Transformer> listTransformersReadyToFight = new ArrayList<Transformer>();
     List<Transformer> listTransformersNotFight = new ArrayList<Transformer>();
     List<Transformer> listOfWinners = new ArrayList<Transformer>();
     List<Transformer> listOfLosers = new ArrayList<Transformer>();
     List<Transformer> listAutobots = listTransformers.stream().filter(transformer -> transformer.getType()=="A").collect(Collectors.toList());
     List<Transformer> listDecepticons = listTransformers.stream().filter(transformer -> transformer.getType()=="D").collect(Collectors.toList());

      listAutobots = listAutobots.stream().sorted((transformer2, transformer) -> Integer.compare(transformer.getRank(), transformer2.getRank())).collect(Collectors.toList());
      listDecepticons = listDecepticons.stream().sorted((transformer2, transformer) -> Integer.compare(transformer.getRank(), transformer2.getRank())).collect(Collectors.toList());

      if(listAutobots.size()>=listDecepticons.size()) {

    	  for(int i=0; i<listAutobots.size(); i++) {
    		  if(listDecepticons.size()-1>=i) {
    			  listTransformersReadyToFight.add(listAutobots.get(i));
    			  listTransformersReadyToFight.add(listDecepticons.get(i));  
    		  }else {
    			  listTransformersNotFight.add(listAutobots.get(i));
    		  }
          }
      }else {
    	  for(int i=0; i<listDecepticons.size(); i++) {
    		  if(listAutobots.size()-1>=i) { 
        		  listTransformersReadyToFight.add(listDecepticons.get(i));
        		  listTransformersReadyToFight.add(listAutobots.get(i));  
    		  }else {
    			  listTransformersNotFight.add(listDecepticons.get(i));
    		  }
          }
      }
//      for(Transformer data : listTransformersReadyToFight) {
//   			logger.info("listTransformersReadyToFight : " + data.getName()+" tipo : "+data.getType()+" firepower : "+data.getFirepower()+
//   			" courage : "+data.getCourage()+" endurance : "+data.getEndurance()+" inteligence : "+data.getIntelligence()
//   			+" rank : "+data.getRank()+" skill : "+data.getSkill()+" speed : "+data.getSpeed()+" strength : "+data.getStrength());
//        }
//      
//      for(Transformer data : listTransformersNotFight) {
//   			logger.info("listTransformersNotReadyToFight : " + data.getName()+" tipo : "+data.getType()+" firepower : "+data.getFirepower()+
//   			" courage : "+data.getCourage()+" endurance : "+data.getEndurance()+" inteligence : "+data.getIntelligence()
//   			+" rank : "+data.getRank()+" skill : "+data.getSkill()+" speed : "+data.getSpeed()+" strength : "+data.getStrength());
//        }
     
      Integer totalBattles = listTransformersReadyToFight.size()/2;
      Integer courageDifference = 0;
      Integer strengthDifference = 0;
      Integer skillDifference = 0;
      Integer overallRatingFighter1 = 0;
      Integer overallRatingFighter2 = 0;
      for(int i=0; i<listTransformersReadyToFight.size(); i++) {
    	  courageDifference = listTransformersReadyToFight.get(i).getCourage()-listTransformersReadyToFight.get(i+1).getCourage();
    	  strengthDifference = listTransformersReadyToFight.get(i).getStrength()-listTransformersReadyToFight.get(i+1).getStrength();
    	  skillDifference = listTransformersReadyToFight.get(i).getSkill()-listTransformersReadyToFight.get(i+1).getSkill();
    	  overallRatingFighter1 = listTransformersReadyToFight.get(i).getStrength()+listTransformersReadyToFight.get(i).getIntelligence()
    			                 +listTransformersReadyToFight.get(i).getSpeed()+listTransformersReadyToFight.get(i).getEndurance()
    			                 +listTransformersReadyToFight.get(i).getFirepower();

    	  overallRatingFighter2 = listTransformersReadyToFight.get(i+1).getStrength()+listTransformersReadyToFight.get(i+1).getIntelligence()
	                             +listTransformersReadyToFight.get(i+1).getSpeed()+listTransformersReadyToFight.get(i+1).getEndurance()
	                             +listTransformersReadyToFight.get(i+1).getFirepower();
//		  logger.info("courageDifference : "+courageDifference+" strengthDifference : "+ strengthDifference+" skillDifference : "+skillDifference);

		  if((listTransformersReadyToFight.get(i).getName().equals(Constant.WINNER_AUTOBOT) && listTransformersReadyToFight.get(i+1).getName().equals(Constant.WINNER_DECEPTICON)) 
				  ||(listTransformersReadyToFight.get(i+1).getName().equals(Constant.WINNER_AUTOBOT) && listTransformersReadyToFight.get(i).getName().equals(Constant.WINNER_DECEPTICON)) ) {
//	    	  logger.info("figther 1 :"+Constant.WINNER_AUTOBOT+" appeared ");
	    	  listOfLosers.clear();
	    	  listOfWinners.clear();
	    	     message=Constant.PREDAKING_VS_OPTIMUS;
	    	     messageBean.setMessage(message);
	    	     break;
	      }else if(listTransformersReadyToFight.get(i).getName().equals(Constant.WINNER_AUTOBOT)) {
//	    	  logger.info("figther 1 :"+Constant.WINNER_AUTOBOT+" appeared ");
	    	  listOfWinners.add(listTransformersReadyToFight.get(i));
	    	  listOfLosers.add(listTransformersReadyToFight.get(i+1));
	      }else if(listTransformersReadyToFight.get(i+1).getName().equals(Constant.WINNER_AUTOBOT)) {
//	    	  logger.info("figther 2 :"+Constant.WINNER_AUTOBOT+" appeared ");
    		  listOfWinners.add(listTransformersReadyToFight.get(i+1));
    		  listOfLosers.add(listTransformersReadyToFight.get(i));
          }else if(listTransformersReadyToFight.get(i).getName().equals(Constant.WINNER_DECEPTICON)) {
//    		  logger.info("figther 1 :"+Constant.WINNER_DECEPTICON+" appeared ");
    		  listOfWinners.add(listTransformersReadyToFight.get(i));
    		  listOfLosers.add(listTransformersReadyToFight.get(i+1));
          }else if(listTransformersReadyToFight.get(i+1).getName().equals(Constant.WINNER_DECEPTICON)) {
//    	      logger.info("figther 2 :"+Constant.WINNER_DECEPTICON+" appeared ");
		      listOfWinners.add(listTransformersReadyToFight.get(i+1));
		      listOfLosers.add(listTransformersReadyToFight.get(i));
          }else if(courageDifference>=Constant.COURAGE_TO_WIN && strengthDifference>=Constant.STRENGTH_TO_WIN) {
//    		  logger.info("figther 1 : more courageDifference"+courageDifference+" and more strengthDifference : "+ strengthDifference);
    		  listOfWinners.add(listTransformersReadyToFight.get(i));
    		  listOfLosers.add(listTransformersReadyToFight.get(i+1));
    	  }else if(courageDifference<=-Constant.COURAGE_TO_WIN && strengthDifference<=-Constant.STRENGTH_TO_WIN) {
//    		  logger.info("figther 2 : more courageDifference"+courageDifference+" and more strengthDifference : "+ strengthDifference);
    		  listOfWinners.add(listTransformersReadyToFight.get(i+1));
    		  listOfLosers.add(listTransformersReadyToFight.get(i));
    	  }else if(skillDifference>=Constant.SKILL_TO_WIN) {
//    		  logger.info("figther 1 : more skillDifference : "+skillDifference);
    		  listOfWinners.add(listTransformersReadyToFight.get(i));
    		  listOfLosers.add(listTransformersReadyToFight.get(i+1));
    	  }else if(skillDifference<=-Constant.SKILL_TO_WIN) {
//    		  logger.info("figther 2 : more skillDifference : "+skillDifference);
    		  listOfWinners.add(listTransformersReadyToFight.get(i+1));
    		  listOfLosers.add(listTransformersReadyToFight.get(i));
    	  }else if(overallRatingFighter1>overallRatingFighter2) {
//    		  logger.info("figther 1 : more overallRating : "+overallRatingFighter1);
    		  listOfWinners.add(listTransformersReadyToFight.get(i));
    		  listOfLosers.add(listTransformersReadyToFight.get(i+1));
    	  }else if(overallRatingFighter1<overallRatingFighter2) {
//    		  logger.info("figther 2 : more overallRating : "+overallRatingFighter2);
    		  listOfWinners.add(listTransformersReadyToFight.get(i+1));
    		  listOfLosers.add(listTransformersReadyToFight.get(i));
    	  }else if(overallRatingFighter1==overallRatingFighter2) {
//    		  logger.info("two losers "+overallRatingFighter2+" - "+overallRatingFighter1);
    		  listOfLosers.add(listTransformersReadyToFight.get(i+1));
    		  listOfLosers.add(listTransformersReadyToFight.get(i));
    	  }
    	  i++;
      }
      
//      for(Transformer data : listOfWinners) {
// 			logger.info("listOfWinners : " + data.getName()+" tipo : "+data.getType()+" firepower : "+data.getFirepower()+
// 			" courage : "+data.getCourage()+" endurance : "+data.getEndurance()+" inteligence : "+data.getIntelligence()
// 			+" rank : "+data.getRank()+" skill : "+data.getSkill()+" speed : "+data.getSpeed()+" strength : "+data.getStrength());
//      }
//      
//      for(Transformer data : listOfLosers) {
// 			logger.info("listOfLosers : " + data.getName()+" tipo : "+data.getType()+" firepower : "+data.getFirepower()+
// 			" courage : "+data.getCourage()+" endurance : "+data.getEndurance()+" inteligence : "+data.getIntelligence()
// 			+" rank : "+data.getRank()+" skill : "+data.getSkill()+" speed : "+data.getSpeed()+" strength : "+data.getStrength());
//      }
      
      if(listOfWinners.size()>0) {
    	  
    	  Long counterAutobots = listOfWinners.stream()
                  .filter(trasformer -> trasformer.getType().equals(Constant.AUTOBOTS_LETTER))
                  .count();
    	  
    	  Long counterDecepticons = listOfWinners.stream()
                  .filter(trasformer -> trasformer.getType().equals(Constant.DECEPTICONS_LETTER))
                  .count();
    	  
    	  String winningTeam = "";
    	  String losingTeam= ""; 
    	  StringBuilder teamMembers = new StringBuilder(); 
    	  StringBuilder survivorsLosingTeam = new StringBuilder();
    	  if(counterAutobots>counterDecepticons) {
    		  winningTeam = Constant.AUTOBOTS;
    		  losingTeam= Constant.DECEPTICONS;
    		  message = Constant.WAR_RESULTS;
    		  for (Transformer members : listAutobots) {
    			  teamMembers.append(members.getName()+" ") ;
    		      }
    		  for (Transformer survivorWhoNotFight : listTransformersNotFight) {
    			     if(survivorWhoNotFight.getType().equals(Constant.DECEPTICONS_LETTER)) {
    			    	 survivorsLosingTeam.append(survivorWhoNotFight.getName()+" ");
    			     }
    		      }
    		  for (Transformer survivorWhoWin : listOfWinners) {
 			        if(survivorWhoWin.getType().equals(Constant.DECEPTICONS_LETTER)) {
 			        survivorsLosingTeam.append(survivorWhoWin.getName()+" ");
 			        }
 		      }
    		  

    	  }else if(counterAutobots<counterDecepticons) {
    		  winningTeam = Constant.DECEPTICONS;
    		  losingTeam= Constant.AUTOBOTS;
    		  message = Constant.WAR_RESULTS;
				for (Transformer members : listDecepticons) {
					teamMembers.append(members.getName() + " ");
				}
				for (Transformer survivorWhoNotFight : listTransformersNotFight) {
					if (survivorWhoNotFight.getType().equals(Constant.AUTOBOTS_LETTER)) {
						survivorsLosingTeam.append(survivorWhoNotFight.getName() + " ");
					}
				}
				for (Transformer survivorWhoWin : listOfWinners) {
					if (survivorWhoWin.getType().equals(Constant.AUTOBOTS_LETTER)) {
						survivorsLosingTeam.append(survivorWhoWin.getName() + " ");
					}
				}
    	  }else {
    		  message = Constant.WAR_TIE;
    	  }
    	  
    	  if(survivorsLosingTeam.length()==0) {
    		  survivorsLosingTeam.append(Constant.NO_SURVIVORS);
    	  }
    	     message = message.replace(Constant.REPLACE1, Integer.toString(totalBattles)).
    	    		 replace(Constant.REPLACE2, winningTeam).
    	    		 replace(Constant.REPLACE3, teamMembers).
    	    		 replace(Constant.REPLACE4, losingTeam).
    	    		 replace(Constant.REPLACE5, survivorsLosingTeam);
    	     
    	     if(listOfWinners.size()>1) {
    	      message = message.replace(Constant.BATTLE, Constant.BATTLES);
    	     }
    	     
    	  
      }
     messageBean.setMessage(message);
     message = Utilities.mensajeToJson(messageBean);

		return message;
	}
    

 
    
}
