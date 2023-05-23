import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RemoteService {
  http: HttpClient;
  baseURL: string = 'http://localhost:7777'

  constructor(http: HttpClient) {
    this.http = http;
  }

  post(testModel: TestModel): Observable<TestModel> {
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    return this.http.post<TestModel>(this.baseURL + '/test/post', JSON.stringify(testModel), options)
      .pipe(
        retry(1),
        catchError(this.errorHandler)
      );
  }

  get(): Observable<TestModel[]> {
    return this.http.get<TestModel[]>(this.baseURL + '/test/get')
      .pipe(
        retry(1),
        catchError(this.errorHandler)
      )
  }


  // Error handling
  errorHandler(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}

export class TestModel {
  id?: number;
  message: String;
  constructor(message: String, id?: number) {
    this.message = message;
    this.id = id;
  }
}
