package com.revature.model;

public class Receipt {
	
	private int id;
	private int rid;
	private String status;
	private String details;
	private double amount;
	private String statusDate;
	private String purchaseDate;
	private String resolvedBy;
	private String outcome;

	
	public Receipt() {
		super();
	}


	public Receipt(int id, int rid, String status, String details, double amount, String statusDate,
			String purchaseDate, String resolvedBy, String outcome) {
		super();
		this.id = id;
		this.rid = rid;
		this.status = status;
		this.details = details;
		this.amount = amount;
		this.statusDate = statusDate;
		this.purchaseDate = purchaseDate;
		this.resolvedBy = resolvedBy;
		this.outcome = outcome;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getStatusDate() {
		return statusDate;
	}


	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public String getResolvedBy() {
		return resolvedBy;
	}


	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}


	public String getOutcome() {
		return outcome;
	}


	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + id;
		result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
		result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
		result = prime * result + ((resolvedBy == null) ? 0 : resolvedBy.hashCode());
		result = prime * result + rid;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusDate == null) ? 0 : statusDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipt other = (Receipt) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id != other.id)
			return false;
		if (outcome == null) {
			if (other.outcome != null)
				return false;
		} else if (!outcome.equals(other.outcome))
			return false;
		if (purchaseDate == null) {
			if (other.purchaseDate != null)
				return false;
		} else if (!purchaseDate.equals(other.purchaseDate))
			return false;
		if (resolvedBy == null) {
			if (other.resolvedBy != null)
				return false;
		} else if (!resolvedBy.equals(other.resolvedBy))
			return false;
		if (rid != other.rid)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusDate == null) {
			if (other.statusDate != null)
				return false;
		} else if (!statusDate.equals(other.statusDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Receipt [id=" + id + ", rid=" + rid + ", status=" + status + ", details=" + details + ", amount="
				+ amount + ", statusDate=" + statusDate + ", purchaseDate=" + purchaseDate + ", resolvedBy="
				+ resolvedBy + ", outcome=" + outcome + "]";
	}


	
	

}
