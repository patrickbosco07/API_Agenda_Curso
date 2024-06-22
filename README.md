```mermaid

classDiagram
    class Turma {
        <<Entity>>
        Integer id
        String codigo
        String semestre
    }

    class Professor {
        <<Entity>>
        Integer id
        String nome
        String sobrenome
    }

    class Curso {
        <<Entity>>
        Integer id
        String nome
        String agenda
        String turma
        String professor
    }

    class Agenda {
        <<Entity>>
        Integer id
        String dia
        String materia
        String sala
    }
    
    Turma --> Curso : "1..*" 
    Professor --> Curso : "1..*"
    Agenda --> Curso : "1..*"


```mermaid
