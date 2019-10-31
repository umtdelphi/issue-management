import { ApiService } from '../api.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';


@Injectable({
    providedIn: 'root'
  })
export class IssueService{

    private ISSUE_PATH = "/issue";

constructor (private apiService: ApiService){
    
}

getAll():Observable<any>{

return this.apiService.get(this.ISSUE_PATH).pipe(map(
    res=>{ 
        if(res){
            return res;
        }else{
            console.log(res);            
        }

    }
));
}

getById(id):Observable<any>{

    return this.apiService.get(this.ISSUE_PATH,id).pipe(map(
        res=>{ 
            if(res){
                return res;
            }else{
                console.log(res);            
            }
    
        }
    ));   
}

createIssue(issue):Observable<any>{
    return this.apiService.get(this.ISSUE_PATH,issue).pipe(map(
        res=>{ 
            if(res){
                return res;
            }else{
                console.log(res);            
            }
    
        }
    ));
}


delete(id):Observable<any>{
    return this.apiService.get(this.ISSUE_PATH,id).pipe(map(
        res=>{ 
            if(res){
                return res;
            }else{
                console.log(res);            
            }
    
        }
    )); 
}

}