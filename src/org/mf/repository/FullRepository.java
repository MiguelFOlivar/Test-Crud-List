package org.mf.repository;

public interface FullRepository <T> extends CRUD<T>, OrderBy<T>, Paginable<T>, Count{

}
