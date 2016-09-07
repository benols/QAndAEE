/**
 * @author Benjamin Olsson
 */
/*

@Stateless
public class EjbAdmin {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean checkUser(String username, String password){
        Admin admin = new Admin();
        try{
            admin = (Admin) entityManager.createNamedQuery("validate").setParameter("username",username).setParameter("password",password).getSingleResult();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void addUser(Admin dataEntry ) {
        Admin admin = new Admin();
        admin.setUsername(dataEntry.getUsername());
        admin.setPassword(dataEntry.getPassword());
        entityManager.persist(admin);
    }
}


*/
