import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError  } from 'rxjs/operators'; 
import  'rxjs/add/observable/of'; 
import {environment }  from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private  httpOptions ={
    headers :new HttpHeaders(
      {
        'Content-Type' :'applicaiton/json'
      }
    )
  }

  constructor(private http: HttpClient ) { 

  }
  

  get(path: string,params:HttpParams=new HttpParams()):Observable<any>
  {

    return this.http.get(environment.API_BASE_PATH+path,{params}).pipe(catchError(this.formatError)
    );
  }

  post(path: string,params:HttpParams=new HttpParams()):Observable<any>
  {

    return this.http.post(environment.API_BASE_PATH+path,JSON.stringify(params),this.httpOptions ).pipe(catchError(this.formatError)
    );
  }

  put(path: string,params:HttpParams=new HttpParams()):Observable<any>
  {

    return this.http.put(environment.API_BASE_PATH+path,JSON.stringify(params),this.httpOptions).pipe(catchError(this.formatError)
    );
  }

  delete(path: string,params:HttpParams=new HttpParams()):Observable<any>
  {

    return this.http.delete(environment.API_BASE_PATH+path,{params}).pipe(
      catchError(this.formatError)
    );
  }

  private formatError(error :any ){

  return Observable.of(environment.API_BASE_PATH+error.error)
  }
  
}
