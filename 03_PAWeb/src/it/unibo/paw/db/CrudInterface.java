package it.unibo.paw.db;

public interface CrudInterface<T> {
	public void create() ;
	public T read();
	public void update(T item);
	public void delete(T item);

}
