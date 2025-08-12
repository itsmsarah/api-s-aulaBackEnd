package com.example.api_alunos.Model;


import jakarta.persistence.*;
//permite que vc trabalhe com dados armazenados no banco de dados

@Entity
//marca esta classe como uma entidade
//indicando que ela representa uma tabela no banco de dados

@Table(name="tb_alunos")
//especifica o nome da tabela no banco de dados no qual a entidade
//está mapeada


public class Aluno {
    @Id
    //marca o campo id como chave primária

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //configurar a geração automática do valor
    //da chabe primária pelo bancco de dados

    private Long id;

    @Column(nullable = false)
    private String nome;
    //indica que o campo 'nome' não pode
    //ser nulo no banco de dados

    @Column(nullable = false,unique = true)
    private String email;
    //indica que o campo 'email' não ppde ser
    //nulo e deve ter um valor único no banco de dados

    public Aluno(){
        //os construtores(vazio e com argumento)
        //são importantes para a criação de
        //objetos "Alunos"
    }


    public Aluno(String nome, String email) {

        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
