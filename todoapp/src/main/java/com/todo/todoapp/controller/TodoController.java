package com.todo.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.todoapp.entity.Todo;
import com.todo.todoapp.mapper.TodoMapper;

/*
 * このクラスから、Mapperインターフェースのメソッドを呼び出し、
  そのメソッドによってDBからデータを取得し、そのデータを埋め込んで、ブラウザに表示する。
 */
@Controller
public class TodoController {
  
  /*
   * @Autowiredアノテーションが付与されたフィールドやコンストラクタ、またはメソッドパラメータに、
   * Springが管理するBeanのインスタンスを自動的に注入します。
   * TodoMapperという名前のBeanが注入されることになります。
   */
  @Autowired
  TodoMapper todoMapper;

  /*
   * RequestMappingは、Spring MVCアプリケーションでHTTPリクエストを処理するために使用されます。
   * @RequestMapping(value="/")は、ルートパスにマッピングされたリクエストハンドラメソッドを定義しています。
   * つまり、アプリケーションのルートパス（今回はhttp://localhost:8080/）にアクセスした場合、
   * このメソッドが処理を担当することになります。
   * /にアクセスされた場合にindexという名前のViewを表示するように設定されています。
   */
  @RequestMapping(value="/")
  public String index(Model model) {
    /*
     * Modelオブジェクトは、ビューにデータを渡すためのオブジェクトです。
     * このindexメソッドでは、Modelオブジェクトにtodosという名前で、全てのTodoオブジェクトを含むリストを設定しています。
     */
    // List<Todo> list = todoMapper.selectAll();

    /*
     * 未完了のTodoオブジェクトのリストを設定している。
     */
    List<Todo> list = todoMapper.selectIncomplete();
    /*
     * 完了済のTodoオブジェクトのリストを設定している。
     */
    List<Todo> doneList = todoMapper.selectComplete();
    /*
     * indexビューでtodosという名前でリストを参照できるようになります。
     */
    model.addAttribute("todos",list);
    /*
     * indexビューでdoneTodosという名前でリストを参照できるようになります。
     */
    model.addAttribute("doneTodos",doneList);
    return "index";
  }

  /*
   * /addというURLにPOSTリクエストが送信された場合、このメソッドが処理を担当することになります。
   */
  @RequestMapping(value="/add")
  public String add(Todo todo) {
    /*
     * TodoMapperを使って引数で渡されたTodoオブジェクトをデータベースに追加しています。
     */
    todoMapper.add(todo);
    /*
     * /にリダイレクトするための命令です。
     * つまり、addメソッドが正常に処理された後、ブラウザを/にリダイレクトすることになります。
     */
    return "redirect:/";
  }

  /*
   * /updateというURLにPOSTリクエストが送信された場合、このメソッドが処理を担当することになります。
   */
  @RequestMapping(value="/update")
  public String update(Todo todo) {
    /*
     * TodoMapperを使って引数で渡されたTodoオブジェクトをデータベースで更新しています。
     */
    todoMapper.update(todo);
    return "redirect:/";
  }

  /*
   * /deleteというURLにPOSTリクエストが送信された場合、このメソッドが処理を担当することになります。
   */
  @RequestMapping(value="/delete")
  public String delete() {
    todoMapper.delete();
    return "redirect:/";
  }
}
