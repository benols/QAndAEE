import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Benjamin Olsson
 */
@Entity
@Table(name="Admin")
@NamedQueries({
@NamedQuery(name="validate", query="SELECT u FROM Admin u WHERE u.username = :username AND u.password = :password")
//@NamedQuery(name="selectAllIDs",query="SELECT id FROM tabell id"),
})
public class Admin implements Serializable {
    public Admin(){    }



    public Admin(String username, String password, long id){
        //this.password = password;
        setUsername(username);
        setPassword(password);
        setId(id);
    }
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
