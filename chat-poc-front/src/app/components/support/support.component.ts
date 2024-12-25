import { Component, OnInit } from '@angular/core';
import { SupportService } from 'src/app/services/support.service';
import { Message } from 'src/app/interfaces/message.interface';

@Component({
  selector: 'app-chat',
  templateUrl: './support.component.html',
  styleUrls: ['./support.component.scss']
})
export class SupportComponent implements OnInit {
  messages: Message[] = [];
  newMessage: Partial<Message> = { sender: '', content: '' };

  constructor(private supportService: SupportService) {}

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(): void {
    this.supportService.getMessages().subscribe((data: Message[]) => {
      this.messages = data;
    });
  }

  sendMessage(): void {
    if (this.newMessage.sender && this.newMessage.content) {
      const messageToSend = {
        sender: this.newMessage.sender,
        content: this.newMessage.content
      };
      this.supportService.sendMessage(messageToSend).subscribe((newMessage: Message) => {
        this.newMessage.content = ''; // Réinitialiser le contenu
        this.loadMessages(); // Recharger les messages
      });
    }
  }
}
