import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Page } from '../common.models';

@Component({
  selector: 'app-change-page',
  templateUrl: './change-page.component.html',
  styleUrls: ['./change-page.component.css']
})
export class ChangePageComponent implements OnInit {
  @Output() setPage: EventEmitter<Page> = new EventEmitter();
  @Input() pageNo: number;
  @Input() totalPages: number;



  public page = Page;

  constructor() {
    this.pageNo = 0;
    this.totalPages = 0;
   }

  ngOnInit(): void {
  }

  changePage(changePage: Page) {
    this.setPage.emit(changePage);
  }
}
