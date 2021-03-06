package com.gradience.database;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;

public class EditUserObject {

	public HashMap<String, String> execute(String string, String string2, String string3) {
		HashMap<String, String> map = new HashMap<String, String>();
		CallableStatement sttmnt = null;
		try {
			sttmnt = DBConnection.instance().conn.prepareCall("{call EDIT_USER(?,?,?,?,?)}");
			sttmnt.setString("U_ID",string);
			sttmnt.setString("VAR", string2);
			sttmnt.setString("VAL", string3);
			sttmnt.registerOutParameter("MSG", Types.VARCHAR);
			sttmnt.registerOutParameter("TEXT", Types.VARCHAR);
			sttmnt.execute();
			map.put("MSG", sttmnt.getString("MSG"));
			map.put("TEXT", sttmnt.getString("TEXT"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
