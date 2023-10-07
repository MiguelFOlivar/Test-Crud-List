package org.mf.repository;

import java.util.List;

public interface OrderBy <T>{
    List<T> orderBy(String campo, Direction direction);
}
