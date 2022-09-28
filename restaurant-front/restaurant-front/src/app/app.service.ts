import { Injectable } from '@angular/core';
import { catchError, Observable, of, Subject } from 'rxjs';
import { CategoryIntegface, Item, UserInterface } from './common.models';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {
  private itemsUrl = 'http://localhost:8080/api/items';
  private categoriesUrl = 'http://localhost:8080/api/categories';
  private usersUrl = 'http://localhost:8080/api/users';

  

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  constructor(private http: HttpClient) { 
    
  }

  getItems(name: string, pageNo: number): Observable<Item[]> {
    return this.http
      .get<Item[]>(
        `${this.itemsUrl}?name=${name}&pageNo=${pageNo}`
      )
      .pipe(catchError(this.handleError<Item[]>('getItems', [])));
  }

  deleteItem(id: number): Observable<Item> {
    const url = `${this.itemsUrl}/${id}`;

    return this.http
      .delete<Item>(url, this.httpOptions)
      .pipe(catchError(this.handleError<Item>('deleteItem')));
  }

  getCategories(): Observable<CategoryIntegface[]> {
    return this.http
      .get<CategoryIntegface[]>(`${this.categoriesUrl}`)
      .pipe(catchError(this.handleError<Item[]>('getCategories', [])));
  }

  addItem(item: Item): Observable<Item> {
    return this.http
      .post<Item>(this.itemsUrl, item, this.httpOptions)
      .pipe(catchError(this.handleError<Item>('addItem')));
  }

  login(user: UserInterface): Observable<UserInterface> {
    console.log(user);
    return this.http
      .post<UserInterface>(this.usersUrl, user, this.httpOptions)
      .pipe(catchError(this.handleError<UserInterface>('login')));
  }
  
  private handleError<T>(operation = 'operation', result?: T) {
   return (error: any): Observable<T> => {
     // TODO: send the error to remote logging infrastructure
     console.error(error); // log to console instead

     // TODO: better job of transforming error for user consumption
     console.log(`${operation} failed: ${error.message}`);

     // Let the app keep running by returning an empty result.
     return of(result as T);
   };
 }
  
}
