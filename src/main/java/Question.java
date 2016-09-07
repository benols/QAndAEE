/**
 * Created by din on 2016-08-23.
 */
//import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

//Similar to jpa/Tbl1.java
@Entity
@Table(name = "Question")
@NamedQueries({
        @NamedQuery(name="selectAllIDs",query="SELECT t.id FROM Question t"),
        @NamedQuery(name="FQuestion", query="SELECT t FROM Question t"),
        //@NamedQuery(name="selectAllIDs",query="SELECT id FROM tabell id"),
        // @NamedQuery(name="selectAllIDs",query="SELECT id FROM Tabell"),
        //@NamedQuery(name="selectAll",query="SELECT t.question  FROM Question t")
        @NamedQuery(name="selectAll",query="SELECT t FROM Question t"),
        //@NamedQuery(name="validate", query="SELECT DISTINCT u FROM Admins u WHERE u.username = :username AND u.password = :password")
        //@NamedQuery(name="selectQuery", query="SELECT t FROM Question t WHERE LOCATE(:fult,t.id) = 1"),
        //@NamedQuery(name="selectOne",query="SELECT t FROM Question t WHERE LOCATE(:id,t.id) = 1")
})
public class Question implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question;
    private String answer;
    private int chapter;
    private int number;
    private boolean can;

    public Question(int chapter, int number, String question, String answer) {
        this.chapter = chapter;
        this.number = number;
        this.question = question;
        this.answer = answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(){
        this.chapter = 1;
        this.number = 1;
        this.question = "question";
        this.answer = "answer";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isCan() {
        return can;
    }

    public void setCan(boolean can) {
        this.can = can;
    }
    @Override
    public String toString(){
        return question + " " + answer;
    }

}
