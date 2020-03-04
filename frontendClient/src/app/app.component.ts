import { Component } from '@angular/core';
import { BackendService } from './backend.service';
import { TodoItem } from './models/todo-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  searchValue:string = '';
  clearSearch() {
    this.searchValue = null;
  }
  title = 'todo-app';
  todoItems : TodoItem[] = []

  constructor(private backend : BackendService) {
    this.backend.getItems().subscribe((items) => this.todoItems = items);
  }

  addTodo(value){
    this.clearSearch();
    this.backend.createItem(value).subscribe(item => this.todoItems.push(item));
  }

  updateItem(todo : TodoItem, event) {
    var oldTitle = todo.title;
    todo.title = event.target.value;
    this.backend.updateItem(todo).subscribe(() => {}, () => {
      alert("Backend-Fehler");
      todo.title = oldTitle;
    });
  }

  deleteItem(todo : TodoItem) {
    this.backend.deleteItem(todo.id).subscribe(() => {
      this.todoItems = this.todoItems.filter((i) => i.id != todo.id);
    })
  }
}

