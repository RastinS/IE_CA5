package Models;

public class Bid {
	private User    biddingUser;
	private Project project;
	private Integer bidAmount;

	public Bid (User biddingUser, Project project, Integer bidAmount) {
		this.biddingUser = biddingUser;
		this.project = project;
		this.bidAmount = bidAmount;
	}

	public User getBiddingUser () {
		return biddingUser;
	}

	public void setBiddingUser (User biddingUser) {
		this.biddingUser = biddingUser;
	}

	public Project getProject () {
		return project;
	}

	public void setProject (Project project) {
		this.project = project;
	}

	public Integer getBidAmount () {
		return bidAmount;
	}

	public void setBidAmount (Integer bidAmount) {
		this.bidAmount = bidAmount;
	}
}