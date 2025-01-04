import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Test } from '../DasboardPage/test';

@Injectable({
  providedIn: 'root'
})
export class GetAllTestsService {
  private baseUrl = 'http://localhost:8182/user/getAllTests';

  constructor(private http: HttpClient) { }

  getTestsByUsername(username: string): Observable<Test[]> {
    return this.http.get<Test[]>(`${this.baseUrl}/${username}`);
  }
}
