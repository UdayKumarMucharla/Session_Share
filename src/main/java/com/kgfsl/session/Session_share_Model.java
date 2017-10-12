package com.kgfsl.session;

import javax.persistence.*;

@Entity
@Table(name = "sessionmgr")
public class Session_share_Model {
	@Id
	@Column
	private int Session_id;
	@Column
	private String Session_name;
	@Column
	private String Session_data;
	@Column
	private String Session_type;
	@Column
	private char Session_Status;

	public int getSession_id() {
		return Session_id;
	}

	public void setSession_id(int session_id) {
		Session_id = session_id;
	}

	public String getSession_name() {
		return Session_name;
	}

	public void setSession_name(String session_name) {
		Session_name = session_name;
	}

	public String getSession_data() {
		return Session_data;
	}

	public void setSession_data(String session_data) {
		Session_data = session_data;
	}

	public String getSession_type() {
		return Session_type;
	}

	public void setSession_type(String session_type) {
		Session_type = session_type;
	}

	public char getSession_Status() {
		return Session_Status;
	}

	public void setSession_Status(char session_Status) {
		Session_Status = session_Status;
	}


	}
