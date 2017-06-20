package com.fliker.Repository;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Vote")
public class Vote {

	@Id
	private String voteid;
	private String[] voteOptions;
	private String[] voteRepliedby;
	public String getVoteid() {
		return voteid;
	}
	public void setVoteid(String voteid) {
		this.voteid = voteid;
	}
	public String[] getVoteOptions() {
		return voteOptions;
	}
	public void setVoteOptions(String[] voteOptions) {
		this.voteOptions = voteOptions;
	}
	public String[] getVoteRepliedby() {
		return voteRepliedby;
	}
	public void setVoteRepliedby(String[] voteRepliedby) {
		this.voteRepliedby = voteRepliedby;
	}
	
	
	
	
}
