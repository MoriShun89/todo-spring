package com.todo.todoapp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.todo.todoapp.entity.Todo;

/*
 * データベースとJavaオブジェクトのマッピングを行うためのインターフェースで、
 * MyBatisでは、このMapperインターフェースを定義することで、データベースに対するCRUD操作を行うことができます。
 */
@Mapper
public interface TodoMapper {
  
  /*
   * selectAllメソッドは、データベースに格納されている全てのTodoオブジェクトを取得するためのMapperメソッド。
   * データベースに格納されている全てのTodoオブジェクトがリストとして返されます。
   * TodoMapper.xmlのselectAllに対応するSQLを記述。
   */
  public List<Todo> selectAll();

  /*
   * 未完了のTodoオブジェクトを取得するためのMapperメソッド。
   * TodoMapper.xmlのselectIncompleteに対応するSQLを記述。
   */
  public List<Todo> selectIncomplete();

  /*
   * 完了済のTodoオブジェクトを取得するためのMapperメソッド。
   * TodoMapper.xmlのselectIncompleteに対応するSQLを記述。
   */
  public List<Todo> selectComplete();

  /*
   * addメソッドは、データベースに新しいTodoオブジェクトを追加するためのMapperメソッドです。
   * TodoMapper.xmlのaddに対応するSQLを記述。
   */
  public void add(Todo todo);

  /*
   * updateメソッドは、データベースに格納されているTodoオブジェクトを更新するためのMapperメソッドです。
   * Todoは、このメソッドの引数であり、更新するTodoオブジェクトを表します。
   * つまり、このメソッドが呼び出されると、引数として渡されたTodoオブジェクトがデータベース内の対応するレコードで更新されます。
   */
  public void update(Todo todo);

  /*
   * 完了済のTodoを一括削除するためのMapperメソッドです。
   */
  public void delete();

}
