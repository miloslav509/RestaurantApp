import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Page } from '../common.models';

@Component({
  selector: 'app-change-page',
  templateUrl: './change-page.component.html',
  styleUrls: ['./change-page.component.css']
})
export class ChangePageComponent implements OnInit {
  @Output() setPage: EventEmitter<Page> = new EventEmitter();

  public page = Page;

  constructor() { }

  ngOnInit(): void {
  }

  changePage(changePage: Page) {
    this.setPage.emit(changePage);
  }
}
