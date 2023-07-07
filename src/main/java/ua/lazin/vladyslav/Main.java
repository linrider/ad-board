package ua.lazin.vladyslav;

import ua.lazin.vladyslav.entity.*;
import ua.lazin.vladyslav.service.AuthorService;
import ua.lazin.vladyslav.service.CrudService;
import ua.lazin.vladyslav.service.impl.AuthorServiceImpl;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // CrudService<Rubric> rubricService = new CrudServiceImpl<>();
        // CrudService<Author> authorService = new CrudServiceImpl<>();
        AuthorService authorService = new AuthorServiceImpl();
        

        List<Author> result = authorService.findAll( );

        result.forEach(System.out::println);
    }

    public static void createRubric(CrudService<Rubric> crudService) {

        Rubric cars = Rubric.builder().name("Cars").build();
        Rubric bicycles = Rubric.builder().name("Bicycles").build();
        Rubric motorbikes = Rubric.builder().name("Motorbikes").build();

        crudService.save(cars);
        crudService.save(bicycles);
        crudService.save(motorbikes);
    }

    public static void createAuthor(CrudService<Author> crudService) {
        Phone phone1 = Phone.builder().number("+38(063) 270 41 65").build();
        Phone phone2 = Phone.builder().number("+38(96) 270 56 65").build();

        Address address = Address
            .builder()
            .city("Chernihiv")
            .street("Shevchenka")
            .houseNumber("9a")
            .flatNumber(56)
            .build();

        Email email = Email.builder().emailAddress("vasya.pupkin@example.com").build();

        Author author = Author
            .builder()
            .firstName("Vasya")
            .surName("Pupkin")
            .phones(Set.of(phone1, phone2))
            .address(address)
            .email(email)
            .build();

            crudService.save(author);
    }

    public static void printAll() {

    }
}