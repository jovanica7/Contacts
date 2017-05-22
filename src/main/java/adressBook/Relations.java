package adressBook;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.lang.String;

@Entity
@Component
@Table(name = "relations")
public class Relations {
	
	@Id
	@Column(name = "pk")
    private int pk;
	
    @Column(name = "id1")
    private int id1;
    
    @Column(name = "id2")
    private int id2;

    @Column(name = "id1_to_id2_is")
    private String firstToSecond;
    
    @Column(name = "id2_to_id1_is")
    private String secondToFirst;
    
    public Relations(){}

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
    
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getRelationFirstToSecond() {
        return firstToSecond;
    }

    public void setRelationFirstToSecond(String firstToSecond) {
        this.firstToSecond = firstToSecond;
    }

    public String getRelationSecondToFirst() {
        return secondToFirst;
    }

    public void setRelationSecondToFirst(String secondToFirst) {
        this.secondToFirst = secondToFirst;
    }

    
}
