import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SendAnswersService {
  baseUrl: string = "http://localhost:8182/user";

  constructor(private http:HttpClient){}

submitResponsesToBackend(username1: any, startTime: any, responses: any[]) {
  const data = {
    username: username1,
    userResponses: responses,
    startTime: startTime.toISOString(),
  };

  this.http.post(this.baseUrl + "/submitAnswer", data, { responseType: 'text' }).subscribe(
    (response) => {
      console.log('Backend Response:', response);
      // Optionally, handle the response from the backend
    },
    (error) => {
      console.error('Error submitting responses to the backend:', error);
      // Optionally, handle the error
    }
  );
   
}

}
