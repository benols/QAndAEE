/**
 * Created by din on 2016-08-23.
 */

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class IndexBean {

    /*private Long id;
    private int chapter;
    private int number;
    private String question;
    private String answer;
    private boolean can;*/
    //private String username;
    //private String password;
    private Question question1;
    private List<Question> questions;
    int index = 0;
    //private Admin admin = new Admin("admin", "admin", 666L);
    private Admin admin = new Admin();
    private String out;

    @Inject
    //@EJB
    private EjbTable service;
    @Inject
    //private EjbAdmin ejbAdmin;
    @PostConstruct
    public void init() {
        //question1 = new Question(1, 1, "question", "answer");
        long index = 0;
        questions = service.getAll("");
        question1 = questions.get((int)index);
        //ejbAdmin.addUser(admin);
        admin.setUsername("");
        admin.setPassword("");
        out = question1.getQuestion();
    }

    public String login(){
        if(service.checkUser(getUsername(), getPassword())){
            return "loggedIn";
        }
        return "index";
    }
    public String getQuestion() {
        out = question1.getQuestion();
        return question1.getQuestion();
    }

    public void setQuestion(String question) {
        question1.setQuestion(question);
    }

    public void setAnswer(String answer) {
        question1.setAnswer(answer);
    }

    public String viewAnswer(){
        //out = question1.getAnswer();
        return "viewAnswer";
    }

    public List<Question> getDataEntryList(){
        List<Question> ps = service.getAll("");
        return ps;
    }

    public List<Long> getAllIDs(){
        List<Long> ids;
        ids = getAllIDs();
        return ids;
    }

    public String viewNextQuestion(){
        index++;
        question1 = questions.get(index);
        //out = question1.getQuestion();
        /*System.out.println("In getNextQuestion ");
        System.out.println("question1.getId() is " + question1.getId());
        //Long id = question1.getId() + 1;
        index++;
        System.out.println("id is " + index);
        question1 = service.getOne(index);
        //Question question = service.getSpecificQuestion(id);
        //Question question = service.getSpecificQuestion(id);
        setQuestion(question1.getQuestion());
        setAnswer(question1.getAnswer());
        setId(question1.getId());*/
        //Point to next tabell value in db and:
        return "viewQuestion";
    }
    public String viewQuestion(){
        return "viewQuestion";
    }

    public String edit(long id){
        System.out.println("Adding");
        setQuestion("");
        setAnswer("");
        return "editQuestion";
    }
    public String submit(){
        System.out.println("submit");
        service.dataEntryAdd(new Question(getQuestion(),getAnswer()));
        setQuestion("");
        setAnswer("");
        return "edit";
    }
    public String add(){
        System.out.println("add");
        service.dataEntryAdd(new Question(getQuestion(),getAnswer()));
        setQuestion("");
        setAnswer("");
        return "add";
    }
    public String remove(Long idRemove){
        service.dataEntryRemove(idRemove);
        return "edit";
    }
    public String removeX(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();

        Long idRemove = Long.getLong(params.get("idRemove"));
        System.out.println("Remove" + idRemove);
        service.dataEntryRemove(idRemove);
        return "admin";
    }

    public String getUsername() {
        return admin.getUsername();
    }

    public void setUsername(String username) {
        admin.setUsername(username);
    }

    public String getPassword() {
        return admin.getPassword();
    }

    public void setPassword(String password){
        admin.setPassword(password);
    }

    public String getOut(){
        return out;
    }

    public void setOut(String out){
        this.out = out;
    }

    public boolean getCan() {return question1.isCan();}

    public void setCan(boolean can) {question1.setCan(can);}

    public long getId() {return question1.getId();}

    public void setId(Long id) { question1.setId(id);}

    public int getChapter() {
        return question1.getChapter();
    }

    public void setChapter(int chapter) {
        question1.setChapter(chapter);
    }

    public int getNumber() {
        return question1.getNumber();
    }

    public void setNumber(int number) {
        question1.setNumber(number);
    }

    public String getAnswer() {
        return question1.getAnswer();
    }
}