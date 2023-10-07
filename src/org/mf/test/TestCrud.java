package org.mf.test;

import org.mf.implementation.ClienteImplRepositorio;
import org.mf.model.Cliente;
import org.mf.repository.Direction;
import org.mf.repository.FullRepository;

import java.util.List;

public class TestCrud {
    public static void main(String[] args) {
        FullRepository<Cliente> repo = new ClienteImplRepositorio();
        repo.create(new Cliente("Mike", "Kaphwan", "mk@mail.com"));
        repo.create(new Cliente("Charles", "Barbas", "ch@mail.com"));
        repo.create(new Cliente("John", "Doe", "jd@mail.com"));
        repo.create(new Cliente("Andrea", "Olivar", "aol@mail.com"));

        List<Cliente> listar = repo.select();
        System.out.println("\t=====Show result=====");
        listar.forEach(System.out::println);
        System.out.println();
        List<Cliente> ordenDesc = repo.orderBy("nombre", Direction.DESC);
        System.out.println("\t=====Order Desc=====");
        ordenDesc.forEach(System.out::println);
        System.out.println();
        List<Cliente> orderAsc = repo.orderBy("nombre", Direction.ASC);
        System.out.println("\t=====Order Asc=====");
        orderAsc.forEach(System.out::println);
        System.out.println();
        System.out.println("\t=====Initial List=====");
        listar.forEach(System.out::println);

        System.out.println();
        System.out.println("\t=====Show Sublist=====");
        List<Cliente> subList = repo.list(0, 3);
        subList.forEach(System.out::println);
        System.out.println();
        System.out.println("\t=====Order by LastName=====");
        List<Cliente> orderList = repo.orderBy("apellido", Direction.DESC);
        orderList.forEach(System.out::println);
        System.out.println();
        //repo.delete(4);
        Cliente update = new Cliente("Andrea", "Olisita", "oli@mail.com");
        update.setId(4);
        repo.update(update);
        listar.forEach(System.out::println);
        System.out.println();
        System.out.println("\t=====Cantidad de registros=====");
        System.out.println("Registros: " + repo.count());
    }
}
