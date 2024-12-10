package Spring_CRUD.CRUD;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext app;

	public static void main( String[] args )
    {
        System.out.println( "Application Running...");
        app = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplate template = app.getBean("JDBCTemplate",JdbcTemplate.class);
        RowMapper<Employee> rm = new RowMapperImp();
        try (Scanner sc = new Scanner(System.in)) {
			int id,choice;
			String name,email,contact_no;
			while(true) {
				System.out.println("1.Insert 2.Update 3.Delete 4.Select by id 5.Select All 6.exit");
				System.out.println("Enter Your Choice:");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					String insert_query = "INSERT INTO EMPLOYEE(id,emp_name,email,contact_no)values(?,?,?,?)";
					System.out.println("Enter id:");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter name:");
					name = sc.nextLine();
					System.out.println("Enter Email:");
					email = sc.nextLine();
					System.out.println("Enter Contact No:");
					contact_no = sc.nextLine();
					int rows=template.update(insert_query,id,name,email,contact_no);
					System.out.println("Rows Inserted "+rows);
					break;
				case 2:
					String update_query = "UPDATE EMPLOYEE SET contact_no = ? WHERE id = ?";
					System.out.println("Enter id to be Updated :");
					int up_id = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter new Contact_no :");
					String up_contact = sc.nextLine();
					int updated_rows = template.update(update_query,up_contact,up_id);
					System.out.println("Updated Rows "+updated_rows);
					break;
				case 3:
					String delete_query = "DELETE FROM EMPLOYEE WHERE id = ?";
					System.out.println("Enter id of record to be deleted :");
					int del_id = sc.nextInt();
					int deleted_rows = template.update(delete_query,del_id);
					System.out.println("Deleted Rows :"+deleted_rows);
					break;
				case 4:
					//Featching Single Data
					String select_query = "SELECT * FROM EMPLOYEE WHERE id = ?";
					System.out.println("Enter id");
					int dis_id = sc.nextInt();
					Employee emp = template.queryForObject(select_query, rm,dis_id);
					System.out.println(emp);
					break;
				case 5:
					//Featching All Data
					String Select_query = "SELECT * FROM EMPLOYEE";
					List<Employee>emps = template.query(Select_query,rm);
					for(Employee e : emps) {
						System.out.println(e);
					}
					break;
				case 6:
					break;
				}
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
