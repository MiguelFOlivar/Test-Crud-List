package org.mf.implementation;

import org.mf.model.Cliente;
import org.mf.repository.AbstractRepository;
import org.mf.repository.Direction;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteImplRepositorio extends AbstractRepository<Cliente> {
    @Override
    public void update(Cliente cliente) {
            Cliente c = this.getById(cliente.getId());
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());
    }

    @Override
    public void delete(Integer id) {
        //Cliente c = this.getById(id);
        this.dataSource.remove(this.getById(id));

    }

    @Override
    public Cliente getById(Integer id) {
        Cliente cliente = null;
        for (Cliente c : this.dataSource) {
            if (c.getId() != null && c.getId().equals(id)) {
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    @Override
    public List<Cliente> orderBy(String campo, Direction direction) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort((a, b) -> {
                int resultado = 0;
                if (direction == Direction.ASC) {
                    resultado = this.ordenar(a, b, campo);
                }else if(direction == Direction.DESC) {
                    resultado = this.ordenar(b, a, campo);
                }
                return resultado;
        });
        return listaOrdenada;
    }

    @Override
    public List<Cliente> list(int from, int until) {
        return this.dataSource.subList(from, until);
    }
    private int ordenar(Cliente a, Cliente b, String campo) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }

    @Override
    public int count() {
        return this.dataSource.size();
    }
}
