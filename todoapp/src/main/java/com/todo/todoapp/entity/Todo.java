package com.todo.todoapp.entity;

// import java.sql.Date;
import lombok.Data;

// テーブルのデータをテーブルのデータを保持するためのクラス
@Data
public class Todo {
  
  // Dataをつけるとgetter、setterを自動生成してくれる
  private long id;
  private String title;
  private int done_flg;
  private String time_limit;
  
}
