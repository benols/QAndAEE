import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Stateless
public class EjbTable {
    @PersistenceContext
    private EntityManager em;

    public List<Question> getAll(String located) {
        List<Question> l;
        if (located.equals(""))
            l = em.createNamedQuery("selectAll").getResultList();
        else
            l = em.createNamedQuery("selectOne").setParameter("filt",located).getResultList();

        return l;
    }

    public List<Long> getAllIDs(){
        return em.createNamedQuery("selectAllIDs", Long.class).getResultList();
    }

    public Question getOne(long id){
        Question table = em.find(Question.class, id);
        return table;
    }

    public Question getSpecificQuestion(Long id){
        Question question = (Question) em.createNamedQuery("selectQuery").setParameter("fult",id).getSingleResult();
        return question;
    }

    public List<Question> list(){
        return em.createQuery("selectAll", Question.class).getResultList();
    }

    public void dataEntryAdd(Question dataEntry) {
        Question question = new Question();
        question.setQuestion(dataEntry.getQuestion());
        question.setAnswer(dataEntry.getAnswer());
        em.persist(question);
    }

    public void dataEntryRemove( Long id) {
        Question table = em.find(Question.class, id);
        em.remove(table);
    }
    ///////////////////////////////////// ADMIN STUFF /////////////////////////////////
    public boolean checkUser(String username, String password){
        List<Admin> admin;
                    try{
            admin =  em.createNamedQuery("validate").setParameter("username",username).setParameter("password",password).getResultList();
            if(admin.isEmpty()) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (Exception e){
            return false;
        }
        //return false;
    }

    public void addUser(Admin dataEntry ) {
        Admin admin = new Admin();
        admin.setUsername(dataEntry.getUsername());
        admin.setPassword(dataEntry.getPassword());
        em.persist(admin);
        //em.persist(dataEntry);
    }
    //////////////////////////////////
}
