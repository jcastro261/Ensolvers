package com.ApiEnsolvers.app.util;

import java.util.Date;

import com.ApiEnsolvers.app.Entity.Note;

public class Util {

	public static boolean checkParameters(String title, String text, Date date) {

		if (title == "")
			return false;
		else if (title == null)
			return false;
		else if (title.trim().length() > 20)
			return false;

		if (text == "")
			return false;
		else if (text == null)
			return false;

		if (date == null)
			return false;

		return true;

	}

	public static boolean checkNote(Note note) {

		if (note.getText() == "")
			return false;
		else if (note.getText() == null)
			return false;
		else if (note == null)
			return false;

		if (note.getTitle() == "")
			return false;
		else if (note.getTitle() == null)
			return false;
		else if (note == null)
			return false;

		return true;

	}
	
	public static boolean checkId(Long idNote) {
		 if (idNote == null)
				return false;
			 return true;
	}

}
