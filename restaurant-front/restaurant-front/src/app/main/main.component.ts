import { Component, OnInit } from '@angular/core';
import { Item, CategoryIntegface, UserInterface } from '../common.models';
import { AppService } from '../app.service';



@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  constructor(private appService: AppService) {

  }

  ngOnInit() {
  }
}
