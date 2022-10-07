package vada.dto;

import java.sql.Timestamp;

public class NoteMessageDTO {

	private int messagenum;
	private String notefromuserid;
	private String notetouserid;
	private String message;
	private Timestamp m_date;

	public NoteMessageDTO() {
   }

	public int getMessagenum() {
		return messagenum;
	}

	public void setMessagenum(int messagenum) {
		this.messagenum = messagenum;
	}

	public String getNotefromuserid() {
		return notefromuserid;
	}

	public void setNotefromuserid(String notefromuserid) {
		this.notefromuserid = notefromuserid;
	}

	public String getNotetouserid() {
		return notetouserid;
	}

	public void setNotetouserid(String notetouserid) {
		this.notetouserid = notetouserid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getM_date() {
		return m_date;
	}

	public void setM_date(Timestamp m_date) {
		this.m_date = m_date;
	}

public NoteMessageDTO(String notefromuserid, String notetouserid, String message, Timestamp m_date) {
      this.notefromuserid = notefromuserid;
      this.notetouserid = notetouserid;
      this.message = message;
      this.m_date = m_date;
   }

	public NoteMessageDTO(String notefromuserid, String notetouserid, String message) {
      this.notefromuserid = notefromuserid;
      this.notetouserid = notetouserid;
      this.message = message;
   }

	@Override
	public String toString() {
		return "NoteMessageDTO [messagenum=" + messagenum + ", notefromuserid=" + notefromuserid + ", notetouserid="
				+ notetouserid + ", message=" + message + ", m_date=" + m_date + "]";
	}


}