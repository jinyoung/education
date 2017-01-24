/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package org.uengine.edu.oop.soc.model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Account")
public class Account implements Serializable {
	public Account() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Account))
			return false;
		Account account = (Account)aObj;
		if ((getAccountId() != null && !getAccountId().equals(account.getAccountId())) || (getAccountId() == null && account.getAccountId() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getAccountId() == null ? 0 : getAccountId().hashCode());
		return hashcode;
	}
	
	@Column(name="AccountId", nullable=false, length=255)	
	@Id	
	private String accountId;
	
	@Column(name="Balance", nullable=false, length=10)	
	private double balance;
	
	public void setBalance(double value) {
		this.balance = value;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAccountId(String value) {
		this.accountId = value;
	}
	
	public String getAccountId() {
		return accountId;
	}
	
	public String getORMID() {
		return getAccountId();
	}
	
	public String toString() {
		return String.valueOf(getAccountId());
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
