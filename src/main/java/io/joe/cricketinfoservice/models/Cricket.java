package io.joe.cricketinfoservice.models;


public class Cricket {
	
	
	public Cricket(String unique_id, String score, String team_1, String team_2) {
		super();
		this.unique_id = unique_id;
		this.score = score;
		this.team_1 = team_1;
		this.team_2 = team_2;
	}

	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
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
	private String unique_id;
	  private String score;
	    private String team_1;
	    private String team_2;
}
