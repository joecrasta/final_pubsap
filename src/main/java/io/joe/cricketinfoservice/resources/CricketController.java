package io.joe.cricketinfoservice.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.joe.cricketinfoservice.models.Cricket;
import io.joe.cricketinfoservice.models.CricketSummary;


@RestController
public class CricketController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

   @RequestMapping("/{unique_id}")
    public String getMovieInfo(@PathVariable("unique_id") String unique_id) {
	   String team1="";
	   String team2="";
	   String winning_score="";
	   String round_rotation="";
	   String match_score="";
        CricketSummary cricketSummary = restTemplate.getForObject("http://cricapi.com/api/cricketScore?unique_id=" + unique_id + "&apikey=" +  apiKey, CricketSummary.class);
        
      //  return new Cricket(unique_id, cricketSummary.getScore(), cricketSummary.getTeam_1(),cricketSummary.getTeam_2());
        String[] score=extractInt(cricketSummary.getScore()).split(" ");
        if(Integer.parseInt(score[0])>Integer.parseInt(score[2])) {
        	 team1="(winner)";
        	 winning_score=score[0]+"/"+score[1];
        	 round_rotation=score[1]+score[0]+"/";
        }else
        {
        	 team2="(winner)";
        	 winning_score=score[2]+"/"+score[3];
        	 round_rotation=score[3]+score[2]+"/";
        }
        match_score="The match score is <pre>   </pre> " + cricketSummary.getScore();
    return ""+match_score+"<br><br>"+"Team-1 : " +cricketSummary.getTeam_1()+" "+team1+"<br>"+
    		"Team-2 : "+ cricketSummary.getTeam_2()+" " +team2+"<br>"+
    		"Winning team’s score: "+winning_score+"<br>"+
    		"Round rotation: "+round_rotation;
    }
   String extractInt(String str) 
   { 
       // Replacing every non-digit number 
       // with a space(" ") 
       str = str.replaceAll("[^\\d]", " "); 
 
       // Remove extra spaces from the beginning 
       // and the ending of the string 
       str = str.trim(); 
 
       // Replace all the consecutive white 
       // spaces with a single space 
       str = str.replaceAll(" +", " "); 
 
       if (str.equals("")) 
           return "-1"; 
 
       return str; 
   } 
}
