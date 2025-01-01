package service;



public interface CRUDOperations<T> {
    void create(T item);
    T read(int id) throws Exception;
    void update(T item) throws Exception;
    void delete(int id) throws Exception;
    boolean exists(int id);
}