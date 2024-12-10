package Spring_CRUD.CRUD;


import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowMapperImp implements RowMapper<Employee> {

	public RowMapperImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setEmail(rs.getString(3));
		emp.setConatact_no(rs.getString(4));
		return emp;
	}

}
