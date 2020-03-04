import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TodoItem } from './models/todo-item';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
    providedIn: 'root'
  })

export class BackendService {

    private baseUrl ='http://localhost:8080/todo';
    public $todos: Observable<TodoItem[]>; 
    
    constructor(private http: HttpClient) {
            }
    //GET
    public getItems() : Observable<TodoItem[]> { 
        return this.http.get<TodoItem[]>(`${this.baseUrl}`);
        }
    
    //POST
    public createItem(title: string): Observable<TodoItem> {
        const httpOptions = {
            headers: new HttpHeaders ({
                'Content-Type': 'application/json'
            })
        }
        return this.http.post<TodoItem>(`${this.baseUrl}`, { "title": title}, httpOptions);
    }

    //PUT
    public updateItem(item : TodoItem): Observable<TodoItem> {
        const httpOptions = {
            headers: new HttpHeaders ({
                'Content-Type': 'application/json'
            })
        }
        return this.http.put<TodoItem>(`${this.baseUrl}`, item, httpOptions);
    }

    //DELETE
    deleteItem(id) {
        return this.http.delete(`${this.baseUrl}/${id}`);
    }
}