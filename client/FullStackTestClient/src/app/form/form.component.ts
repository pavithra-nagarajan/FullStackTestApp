import { Component } from '@angular/core';
import { RemoteService, TestModel } from '../remote.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
  remote: RemoteService;
  message: String = "";
  
  constructor(remoteService: RemoteService) {
    this.remote = remoteService;
  }

  submit(): void {
    console.log("Submitting...");
    this.remote.post(new TestModel(this.message)).subscribe();
  }
}
