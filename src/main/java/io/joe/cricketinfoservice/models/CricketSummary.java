package io.joe.cricketinfoservice.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CricketSummary {

    private String score;
    @JsonProperty("team-1")
    private String team_1;
    @JsonProperty("team-2")
    private String team_2;
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getTeam_1() {
		return team_1;
	}
	public void setTeam_1(String team_1) {
		this.team_1 = team_1;
	}
	public String getTeam_2() {
		return team_2;
	}
	public void setTeam_2(String team_2) {
		this.team_2 = team_2;
	}

    
}
