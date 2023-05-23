import { Component } from '@angular/core';
import { RemoteService, TestModel } from '../remote.service';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent {
  remote: RemoteService;
  testModels: TestModel[] = [];

  subscriber = {
    next: (value: any) => {
      this.testModels = value;
    },
    error: (error: any) => {console.log('error...') },
    complete: () => {console.log('complete!')}
  }

  constructor(remoteService: RemoteService) {
    this.remote = remoteService;
    this.remote.get().subscribe(this.subscriber);
  }

}
