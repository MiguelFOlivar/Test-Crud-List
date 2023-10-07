package org.mf.repository;

import java.util.List;

public interface Paginable <T>{
    List<T> list(int from, int until);
}
