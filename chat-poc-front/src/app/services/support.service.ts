import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Message } from '../interfaces/message.interface';

@Injectable({
  providedIn: 'root'
})
export class SupportService {
  private pathService = '/api/chat'; // URL du back-end

  constructor(private http: HttpClient) {}

  // Récupérer l'historique des messages
  getMessages(): Observable<Message[]> {
    return this.http.get<Message[]>(`${this.pathService}/history`);
  }

  // Envoyer un message
  sendMessage(message: { sender: string; content: string }): Observable<Message> {
    return this.http.post<Message>(`${this.pathService}/send`, message);
  }
}
