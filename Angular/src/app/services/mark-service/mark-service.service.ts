import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserStorageService } from '../storage/user-storage.service';
import { Observable } from 'rxjs';

const BASIC_URL = "http://localhost:3000/";

@Injectable({
  providedIn: 'root'
})
export class MarkServiceService {

  constructor(private http: HttpClient) { }

  addMark(markDto: any) {
    return this.http.post(BASIC_URL + `api/mark/${UserStorageService.getUserId()}`, markDto, {
      headers: this.createdAuthorizationHeader(),
    });
  }

  getResult(): Observable<any> {
    return this.http.get(BASIC_URL + `api/marks`, {
      headers: this.createdAuthorizationHeader(),
    });
  }


  createdAuthorizationHeader(): HttpHeaders {
    let authHeader: HttpHeaders = new HttpHeaders();
    return authHeader.set(
      "Authorization",
      "Bearer " + UserStorageService.getToken()
    )
  }

}
