/**
 * @author João Paulo
 */

package br.com.paulo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "sq_name", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODE", nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToOne(mappedBy = "student")
    private Registration registration;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "tb_student_classrom",
            joinColumns = { @JoinColumn(name = "id_student_fk") },
            inverseJoinColumns = { @JoinColumn(name = "id_classrom_fk") })
    private List<Classrom> classrom;

    public Student() {
        this.classrom = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public List<Classrom> getClassrom() {
        return classrom;
    }

    public void setClassrom(List<Classrom> classrom) {
        this.classrom = classrom;
    }

    public void add(Classrom classrom) {
        this.classrom.add(classrom);
    }
}
