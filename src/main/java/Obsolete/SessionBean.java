/*
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

*/
/**
 * @author Benjamin Olsson
 *//*

@Named
@SessionScoped
//Bean that ...
public class SessionBean {
    */
/*@Inject
    private EjbTable service;*//*

    private long currentQuestion = 1;

    public Long getRandomQuestion(){
        List<Long> ids = service.getAllIDs();
        Long index = (Long) ThreadLocalRandom.current().nextLong(ids.size());
        return index;
    }

    public List<Long> getRandomList(){
        List<Long> ids = service.getAllIDs();
        long seed = System.nanoTime();
        Collections.shuffle(ids, new Random(seed));
        return ids;
    }
}
*/
